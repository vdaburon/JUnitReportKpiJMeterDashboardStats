package io.github.vdaburon.jmeter.utils.jsonkpi;

public class CheckKpiResult {
    private String nameKpi;
    private String metricJsonAttribute;
    private String labelRegex;
    private String comparator;
    private String threshold;
    private boolean isKpiFail;
    private String failMessage;

    public String getNameKpi() {
        return nameKpi;
    }

    public void setNameKpi(String nameKpi) {
        this.nameKpi = nameKpi;
    }

    public String getMetricJsonAttribute() {
        return metricJsonAttribute;
    }

    public void setMetricJsonAttribute(String metricJsonAttribute) {
        this.metricJsonAttribute = metricJsonAttribute;
    }

    public String getLabelRegex() {
        return labelRegex;
    }

    public void setLabelRegex(String labelRegex) {
        this.labelRegex = labelRegex;
    }

    public String getComparator() {
        return comparator;
    }

    public void setComparator(String comparator) {
        this.comparator = comparator;
    }

    public String getThreshold() {
        return threshold;
    }

    public void setThreshold(String threshold) {
        this.threshold = threshold;
    }

    public boolean isKpiFail() {
        return isKpiFail;
    }

    public void setKpiFail(boolean kpiFail) {
        isKpiFail = kpiFail;
    }

    public String getFailMessage() {
        return failMessage;
    }

    public void setFailMessage(String failMessage) {
        this.failMessage = failMessage;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CheckKpiResult{");
        sb.append("nameKpi='").append(nameKpi).append('\'');
        sb.append(", metricJsonAttribute='").append(metricJsonAttribute).append('\'');
        sb.append(", labelRegex='").append(labelRegex).append('\'');
        sb.append(", comparator='").append(comparator).append('\'');
        sb.append(", threshold='").append(threshold).append('\'');
        sb.append(", isKpiFail=").append(isKpiFail);
        sb.append(", failMessage='").append(failMessage).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
