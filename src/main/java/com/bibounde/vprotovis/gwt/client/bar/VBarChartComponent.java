package com.bibounde.vprotovis.gwt.client.bar;

import java.util.logging.Logger;

import com.bibounde.vprotovis.gwt.client.Tooltip;
import com.bibounde.vprotovis.gwt.client.TooltipComposite.ArrowStyle;
import com.bibounde.vprotovis.gwt.client.UIDLUtil;
import com.bibounde.vprotovis.gwt.client.VAbstractChartComponent;
import com.google.gwt.user.client.DOM;

public class VBarChartComponent extends VAbstractChartComponent {

    public static final String UIDL_DATA_SERIES_COUNT = "vprotovis.data.series.count";
    public static final String UIDL_DATA_SERIES_NAMES = "vprotovis.data.series.names";
    public static final String UIDL_DATA_GROUPS_COUNT = "vprotovis.data.groups.count";
    public static final String UIDL_DATA_GROUPS_NAMES = "vprotovis.data.groups.names";
    public static final String UIDL_DATA_GROUP_NAME = "vprotovis.data.group.name.";
    public static final String UIDL_DATA_SERIE_NAME = "vprotovis.data.serie.name.";
    public static final String UIDL_DATA_GROUP_VALUES = "vprotovis.data.group.values.";
    public static final String UIDL_DATA_GROUP_TOOLTIP_VALUES = "vprotovis.data.group.tooltip.values.";
    public static final String UIDL_OPTIONS_BOTTOM = "vprotovis.options.bottom";
    public static final String UIDL_OPTIONS_LEFT = "vprotovis.options.left";
    public static final String UIDL_OPTIONS_GROUP_WIDTH = "vprotovis.options.group.width";
    public static final String UIDL_OPTIONS_GROUP_INSET = "vprotovis.options.group.inset";
    public static final String UIDL_OPTIONS_BAR_HEIGHT = "vprotovis.options.bar.height";
    public static final String UIDL_OPTIONS_BAR_WIDTH = "vprotovis.options.bar.width";
    public static final String UIDL_OPTIONS_BAR_INSET = "vprotovis.options.bar.inset";
    public static final String UIDL_OPTIONS_PADDING_LEFT = "vprotovis.options.padding.left";
    public static final String UIDL_OPTIONS_PADDING_RIGHT = "vprotovis.options.padding.right";
    public static final String UIDL_OPTIONS_PADDING_TOP= "vprotovis.options.padding.top";
    public static final String UIDL_OPTIONS_PADDING_BOTTOM = "vprotovis.options.padding.bottom";
    public static final String UIDL_OPTIONS_X_AXIS_ENABLED = "vprotovis.options.x.axis.enabled";
    public static final String UIDL_OPTIONS_X_AXIS_LABEL_ENABLED = "vprotovis.options.x.axis.label.enabled";
    public static final String UIDL_OPTIONS_Y_AXIS_ENABLED = "vprotovis.options.y.axis.enabled";
    public static final String UIDL_OPTIONS_Y_AXIS_LABEL_ENABLED = "vprotovis.options.y.axis.label.enabled";
    public static final String UIDL_OPTIONS_Y_AXIS_LABEL_RANGE_D_VALUES = "vprotovis.options.y.axis.label.range.d.values";
    public static final String UIDL_OPTIONS_Y_AXIS_LABEL_RANGE_S_VALUES = "vprotovis.options.y.axis.label.range.s.values";
    public static final String UIDL_OPTIONS_Y_AXIS_GRID_ENABLED = "vprotovis.options.y.axis.grid.enabled";
    
    /** Set the CSS class name to allow styling. */
    public static final String CLASSNAME = "v-vprotovis-barchart";
    
    private Logger LOGGER = Logger.getLogger(VBarChartComponent.class.getName());

    private Tooltip currentTooltip;
    
    /**
     * The constructor should first call super() to initialize the component and
     * then handle any initialization relevant to Vaadin.
     */
    public VBarChartComponent() {
        super();
    }
    
    public String getClassName() {
        return CLASSNAME;
    }
    
    public native void render   () /*-{
    
        var vbarchart = this;
    
        var colors = eval(this.@com.bibounde.vprotovis.gwt.client.bar.VBarChartComponent::getColors()());
        var axisColor = $wnd.pv.color("#969696");
        var legendColor = $wnd.pv.color("#464646");
        var gridColor = $wnd.pv.color("#E4E4E4");
    
        var data = eval(this.@com.bibounde.vprotovis.gwt.client.bar.VBarChartComponent::getData()());
        var serieNames = eval(this.@com.bibounde.vprotovis.gwt.client.bar.VBarChartComponent::getSerieNames()());
        var groupCount = this.@com.bibounde.vprotovis.gwt.client.bar.VBarChartComponent::getGroupCount()();
        var groupNames = eval(this.@com.bibounde.vprotovis.gwt.client.bar.VBarChartComponent::getGroupNames()());
        
        var chartWidth = this.@com.bibounde.vprotovis.gwt.client.bar.VBarChartComponent::getChartWidth()();
        var chartHeight = this.@com.bibounde.vprotovis.gwt.client.bar.VBarChartComponent::getChartHeight()();
        
        var panelBottom = this.@com.bibounde.vprotovis.gwt.client.bar.VBarChartComponent::getPanelBottom()();
        var panelLeft = this.@com.bibounde.vprotovis.gwt.client.bar.VBarChartComponent::getPanelLeft()();
        
        var vis = new $wnd.pv.Panel().canvas(this.@com.bibounde.vprotovis.gwt.client.bar.VBarChartComponent::getDivId()());
        vis.width(chartWidth);
        vis.height(chartHeight);
        
        var marginLeft = this.@com.bibounde.vprotovis.gwt.client.bar.VBarChartComponent::getMarginLeft()();
        var marginRight = this.@com.bibounde.vprotovis.gwt.client.bar.VBarChartComponent::getMarginRight()();
        var marginBottom = this.@com.bibounde.vprotovis.gwt.client.bar.VBarChartComponent::getMarginBottom()();
        var marginTop = this.@com.bibounde.vprotovis.gwt.client.bar.VBarChartComponent::getMarginTop()();
        var paddingLeft = this.@com.bibounde.vprotovis.gwt.client.bar.VBarChartComponent::getPaddingLeft()();
        var paddingRight = this.@com.bibounde.vprotovis.gwt.client.bar.VBarChartComponent::getPaddingRight()();
        var paddingBottom = this.@com.bibounde.vprotovis.gwt.client.bar.VBarChartComponent::getPaddingBottom()();
        var paddingTop = this.@com.bibounde.vprotovis.gwt.client.bar.VBarChartComponent::getPaddingTop()();
        
        var legendAreaWidth = this.@com.bibounde.vprotovis.gwt.client.bar.VBarChartComponent::getLegendAreaWidth()();
        var legendInsetLeft = this.@com.bibounde.vprotovis.gwt.client.bar.VBarChartComponent::getLegendInsetLeft()();
        
        var maxYTick = chartHeight - marginTop;
        var minYTick = marginBottom;
        
        var yRange = eval(this.@com.bibounde.vprotovis.gwt.client.bar.VBarChartComponent::getVerticalAxisLabelRangeDValues()());
        var yRangeText = eval(this.@com.bibounde.vprotovis.gwt.client.bar.VBarChartComponent::getVerticalAxisLabelRangeSValues()());
        
        var groupWidth = this.@com.bibounde.vprotovis.gwt.client.bar.VBarChartComponent::getGroupWidth()();
        var groupInset = this.@com.bibounde.vprotovis.gwt.client.bar.VBarChartComponent::getGroupInset()();
        var barWidth = this.@com.bibounde.vprotovis.gwt.client.bar.VBarChartComponent::getBarWidth()();
        var barHeight = this.@com.bibounde.vprotovis.gwt.client.bar.VBarChartComponent::getBarHeight()();
        var barInset = this.@com.bibounde.vprotovis.gwt.client.bar.VBarChartComponent::getBarInset()();
        
        //Grid management
        if (this.@com.bibounde.vprotovis.gwt.client.bar.VBarChartComponent::isYAxisGridEnabled()()) {
            var grid = vis.add($wnd.pv.Rule).data(yRange);
            grid.visible(function(d) {
                var ret = (d * barHeight) + panelBottom;
                return ret < maxYTick && ret >= minYTick;
            });
            grid.bottom(function(d) {
                return (d * barHeight) + panelBottom;
            });
            grid.left(0 + marginLeft);
            grid.width(chartWidth - marginLeft - marginRight - legendAreaWidth - legendInsetLeft);
            grid.strokeStyle(gridColor);
        }
        
        //Panel and bar management
        var panel = vis.add($wnd.pv.Panel).def("active", false).def("activeIndex", -1).data(data);
        panel.width(groupWidth).bottom(panelBottom).left(function() {
            return paddingLeft + panelLeft + this.index * (groupWidth + groupInset);
        });
                
        var bar = panel.add($wnd.pv.Bar).data(function(d){ return d});
        bar.bottom(function(d) {
            if (d < 0) {
                return d * barHeight;
            } else {
                return 0;
            }
        });
        bar.width(barWidth).height(function(d) {return Math.abs(d * barHeight);});
        bar.left(function(){return this.index * (barWidth + barInset)});
        //Color management
        bar.fillStyle(colors.by($wnd.pv.index));
    
        //Horizontal axis management
        if (this.@com.bibounde.vprotovis.gwt.client.bar.VBarChartComponent::isXAxisEnabled()()) {
            var rule = vis.add($wnd.pv.Rule);
            
            rule.bottom(panelBottom).width(chartWidth - marginLeft - marginRight - legendAreaWidth - legendInsetLeft).left(0 + marginLeft);
            rule.strokeStyle(axisColor);
            
            if (this.@com.bibounde.vprotovis.gwt.client.bar.VBarChartComponent::isXAxisLabelEnabled()()) {
        
                var tick = vis.add($wnd.pv.Rule).data(groupNames);
                tick.left(function() {
                    return paddingLeft + panelLeft + this.index * (groupWidth + groupInset) + (groupWidth / 2);
                });
                tick.bottom(panelBottom - 3);
                tick.height(3);
                tick.strokeStyle(axisColor);
                tick.anchor("bottom").add($wnd.pv.Label).text(function(d) {
                    return d;
                }).textStyle(axisColor);
            }
        }
        
        //Vertical axis management
        if (this.@com.bibounde.vprotovis.gwt.client.bar.VBarChartComponent::isYAxisEnabled()()) {
            var rule = vis.add($wnd.pv.Rule);
            rule.bottom(0 + marginBottom).left(panelLeft).height(chartHeight - marginBottom - marginTop);
            rule.strokeStyle(axisColor);
            
            if (this.@com.bibounde.vprotovis.gwt.client.bar.VBarChartComponent::isYAxisLabelEnabled()()) {
        
                var tick = vis.add($wnd.pv.Rule).data(yRange);
                tick.visible(function(d) {
                    var ret = (d * barHeight) + panelBottom;
                    return ret <= maxYTick && ret >= minYTick;
                });
                tick.bottom(function(d) {
                    return (d * barHeight) + panelBottom;
                });
                tick.left(panelLeft - 3);
                tick.width(3);
                tick.strokeStyle(axisColor);
                tick.anchor("left").add($wnd.pv.Label).text(function() {
                    return yRangeText[this.index];
                }).textStyle(axisColor);
            }
        }
        
        //Event management
        if (this.@com.bibounde.vprotovis.gwt.client.bar.VBarChartComponent::isTooltipEnabled()()) {
            var tooltips = eval(this.@com.bibounde.vprotovis.gwt.client.bar.VBarChartComponent::getTooltips()());
            bar.event('mouseover', function() {
                var left = this.left() + this.parent.left();
                var top = this.top() + this.parent.top();
                var bottom = this.bottom() + this.parent.bottom();
                var barWidth = this.width();
                var barBbottom = this.bottom();
                var tooltip = tooltips[this.parent.index][this.index];
                vbarchart.@com.bibounde.vprotovis.gwt.client.bar.VBarChartComponent::showTooltip(DDDDDLjava/lang/String;)(left, top, bottom, barBbottom, barWidth, tooltip);
                
                return this;
            });
            bar.event('mouseout', function() {
                vbarchart.@com.bibounde.vprotovis.gwt.client.bar.VBarChartComponent::hideTooltip()();
                return this;
            });
        }
        
        //Legend management
        if (this.@com.bibounde.vprotovis.gwt.client.bar.VBarChartComponent::isLegendEnabled()()) {
            //Use bar instead of DOT because msie-shim does not support it
            var legend = vis.add($wnd.pv.Bar).data(serieNames);
            legend.top(function(){
                return marginTop + (this.index * 18);
            });
            legend.width(11).height(11).left(chartWidth - marginRight - legendAreaWidth + legendInsetLeft);
            legend.fillStyle(colors.by($wnd.pv.index));
            legend.anchor("left").add($wnd.pv.Label).textBaseline("middle").textMargin(16).textStyle(legendColor);
        }
    
        vis.render();
    }-*/;
    
    public void showTooltip(double left, double top, double bottom, double barBottom, double barWidth, String tooltipText) {
        int arrowOffset = 10;
        int tooltipLeft = this.getElement().getAbsoluteLeft() + Double.valueOf(left).intValue();
        int tooltipTop = this.getElement().getAbsoluteTop() + Double.valueOf(top).intValue();
        int tooltipBottom = this.getElement().getAbsoluteBottom() - Double.valueOf(bottom).intValue();
        
        if (this.currentTooltip == null) {
            this.currentTooltip = new Tooltip(this);
        }
        this.currentTooltip.setText(tooltipText);
        
        //Tooltip location calculation
        this.currentTooltip.show();
        if (barBottom < 0) {
            //Bar with negative value
            if (bottom < this.currentTooltip.getOffsetHeight()) {
                //Display at the right
                this.currentTooltip.setArrowStyle(ArrowStyle.MIDDLE_TOP_LEFT);
                this.currentTooltip.setPopupPosition(tooltipLeft + Double.valueOf(barWidth).intValue() + 2, tooltipBottom - this.currentTooltip.getOffsetHeight());
            } else {
                this.currentTooltip.setArrowStyle(ArrowStyle.TOP_LEFT);
                this.currentTooltip.setPopupPosition(tooltipLeft - arrowOffset+ (Double.valueOf(barWidth).intValue() / 2), tooltipBottom);
            }
        } else {
            if (top < this.currentTooltip.getOffsetHeight()) {
                //Display at the right
                this.currentTooltip.setArrowStyle(ArrowStyle.MIDDLE_TOP_LEFT);
                this.currentTooltip.setPopupPosition(tooltipLeft + Double.valueOf(barWidth).intValue() + 2, tooltipTop);
            } else {
                this.currentTooltip.setArrowStyle(ArrowStyle.BOTTOM_LEFT);
                this.currentTooltip.setPopupPosition(tooltipLeft - arrowOffset+ (Double.valueOf(barWidth).intValue() / 2), tooltipTop - this.currentTooltip.getOffsetHeight());
            }
        }
    }
    
    public void hideTooltip() {
        if (this.currentTooltip != null) {
            this.currentTooltip.hide();
        }
    }
    
    public String getData() {
        StringBuilder ret = new StringBuilder("[");
        int serieCount = this.currentUIDL.getIntVariable(UIDL_DATA_GROUPS_COUNT);
        
        for (int i = 0; i < serieCount; i++) {
            if (i > 0) {
                ret.append(", ");
            }
            ret.append("[");
            
            String[] values = this.currentUIDL.getStringArrayVariable(UIDL_DATA_GROUP_VALUES + i);
            for (int j = 0; j < values.length; j++) {
                if (j > 0) {
                    ret.append(", ");
                }
                ret.append(values[j]);
            }
            ret.append("]");
        }
        ret.append("]");
        return ret.toString();
    };
    
    
    
    public double getPanelBottom() {
        return this.currentUIDL.getDoubleVariable(UIDL_OPTIONS_BOTTOM);
    }
    
    public double getPanelLeft() {
        return this.currentUIDL.getDoubleVariable(UIDL_OPTIONS_LEFT);
    }
    
    public double getGroupWidth() {
        return this.currentUIDL.getDoubleVariable(UIDL_OPTIONS_GROUP_WIDTH);
    }
    
    public int getGroupCount() {
        return this.currentUIDL.getIntVariable(UIDL_DATA_GROUPS_COUNT);
    }
    
    public double getGroupInset() {
        return this.currentUIDL.getDoubleVariable(UIDL_OPTIONS_GROUP_INSET);
    }
    
    public double getBarWidth() {
        return this.currentUIDL.getDoubleVariable(UIDL_OPTIONS_BAR_WIDTH);
    }
    
    public double getBarHeight() {
        return this.currentUIDL.getDoubleVariable(UIDL_OPTIONS_BAR_HEIGHT);
    }
    
    public double getBarInset() {
        return this.currentUIDL.getDoubleVariable(UIDL_OPTIONS_BAR_INSET);
    }
    
    public double getPaddingLeft() {
        return this.currentUIDL.getDoubleVariable(UIDL_OPTIONS_PADDING_LEFT);
    }
    public double getPaddingRight() {
        return this.currentUIDL.getDoubleVariable(UIDL_OPTIONS_PADDING_RIGHT);
    }
    public double getPaddingTop() {
        return this.currentUIDL.getDoubleVariable(UIDL_OPTIONS_PADDING_TOP);
    }
    public double getPaddingBottom() {
        return this.currentUIDL.getDoubleVariable(UIDL_OPTIONS_PADDING_BOTTOM);
    }
    public boolean isXAxisEnabled() {
        return this.currentUIDL.getBooleanVariable(UIDL_OPTIONS_X_AXIS_ENABLED);
    }
    public boolean isXAxisLabelEnabled() {
        return this.currentUIDL.getBooleanVariable(UIDL_OPTIONS_X_AXIS_LABEL_ENABLED);
    }
    
    public String getGroupNames() {
        String[] values = this.currentUIDL.getStringArrayVariable(UIDL_DATA_GROUPS_NAMES);
        return UIDLUtil.getJSArray(values, true);
    }
    
    public boolean isYAxisEnabled() {
        return this.currentUIDL.getBooleanVariable(UIDL_OPTIONS_Y_AXIS_ENABLED);
    }
    
    public boolean isYAxisLabelEnabled() {
        return this.currentUIDL.getBooleanVariable(UIDL_OPTIONS_Y_AXIS_LABEL_ENABLED);
    }
    
    public boolean isYAxisGridEnabled() {
        return this.currentUIDL.getBooleanVariable(UIDL_OPTIONS_Y_AXIS_GRID_ENABLED);
    }
    
    public String getVerticalAxisLabelRangeDValues() {
        String[] values = this.currentUIDL.getStringArrayVariable(UIDL_OPTIONS_Y_AXIS_LABEL_RANGE_D_VALUES);
        return UIDLUtil.getJSArray(values, false);
    }
    
    public String getVerticalAxisLabelRangeSValues() {
        String[] values = this.currentUIDL.getStringArrayVariable(UIDL_OPTIONS_Y_AXIS_LABEL_RANGE_S_VALUES);
        return UIDLUtil.getJSArray(values, true);
    }
    
    public String getSerieNames() {
        String[] values = this.currentUIDL.getStringArrayVariable(UIDL_DATA_SERIES_NAMES);
        return UIDLUtil.getJSArray(values, true);
    }
    
    public String getTooltips() {
        StringBuilder ret = new StringBuilder("[");
        
        int serieCount = this.currentUIDL.getIntVariable(UIDL_DATA_GROUPS_COUNT);
        for (int i = 0; i < serieCount; i++) {
            if (i > 0) {
                ret.append(", ");
            }
            String[] values = this.currentUIDL.getStringArrayVariable(UIDL_DATA_GROUP_TOOLTIP_VALUES + i);
            
            ret.append("[");
            for (int j = 0; j < values.length; j++) {
                if (j > 0) {
                    ret.append(", ");
                }
                ret.append("'").append(values[j]).append("'");
            }
            ret.append("]");
        }
        ret.append("]");
        return ret.toString();
    }
}
