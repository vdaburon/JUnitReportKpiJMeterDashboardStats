package io.github.vdaburon.jmeter.utils.jsonkpi;

import java.util.Map;
public class Statistic {
    /*

         "SC03_P01_ACCUEIL" : {
            "transaction" : "SC03_P01_ACCUEIL",
                    "sampleCount" : 33,
                    "errorCount" : 0,
                    "errorPct" : 0.0,
                    "meanResTime" : 63.5757575757576,
                    "medianResTime" : 65.0,
                    "minResTime" : 51.0,
                    "maxResTime" : 89.0,
                    "pct1ResTime" : 72.0,
                    "pct2ResTime" : 78.49999999999996,
                    "pct3ResTime" : 89.0,
                    "throughput" : 0.09296979326898697,
                    "receivedKBytesPerSec" : 3.4831895691061376,
                    "sentKBytesPerSec" : 0.14063497048209064
    },
    */
    private String label; // SC03_P01_ACCUEIL
    private String transaction; // SC03_P01_ACCUEIL
    private int sampleCount; // 33
    private int errorCount; // 0
    private double errorPct; // 0.0,
    private double meanResTime; // 63.5757575757576,
    private double medianResTime; // 65.0,
    private double minResTime; // 51.0,
    private double maxResTime; // 89.0,
    private double pct1ResTime; // 72.0,
    private double pct2ResTime; // 78.49999999999996,
    private double pct3ResTime; // 89.0,
    private double throughput; // 0.09296979326898697,
    private double receivedKBytesPerSec; // 3.4831895691061376,
    private double sentKBytesPerSec; // 0.14063497048209064

    public Statistic(Map <String, Object> statMap) {

        transaction = (String) statMap.get("transaction");
        label = transaction;
        sampleCount = (int) statMap.get("sampleCount");
        errorCount = (int) statMap.get("errorCount");
        errorPct = (double) statMap.get("errorPct");
        meanResTime = (double) statMap.get("meanResTime");
        medianResTime = (double) statMap.get("medianResTime");
        minResTime = (double) statMap.get("minResTime");
        maxResTime = (double) statMap.get("maxResTime");
        pct1ResTime = (double) statMap.get("pct1ResTime");
        pct2ResTime = (double) statMap.get("pct2ResTime");
        pct3ResTime = (double) statMap.get("pct3ResTime");
        throughput = (double) statMap.get("throughput");
        receivedKBytesPerSec = (double) statMap.get("receivedKBytesPerSec");
        sentKBytesPerSec = (double) statMap.get("sentKBytesPerSec");
    }
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    public long getSampleCount() {
        return sampleCount;
    }

    public void setSampleCount(int sampleCount) {
        this.sampleCount = sampleCount;
    }

    public long getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(int errorCount) {
        this.errorCount = errorCount;
    }

    public double getErrorPct() {
        return errorPct;
    }

    public void setErrorPct(double errorPct) {
        this.errorPct = errorPct;
    }

    public double getMeanResTime() {
        return meanResTime;
    }

    public void setMeanResTime(double meanResTime) {
        this.meanResTime = meanResTime;
    }

    public double getMedianResTime() {
        return medianResTime;
    }

    public void setMedianResTime(double medianResTime) {
        this.medianResTime = medianResTime;
    }

    public double getMinResTime() {
        return minResTime;
    }

    public void setMinResTime(double minResTime) {
        this.minResTime = minResTime;
    }

    public double getMaxResTime() {
        return maxResTime;
    }

    public void setMaxResTime(double maxResTime) {
        this.maxResTime = maxResTime;
    }

    public double getPct1ResTime() {
        return pct1ResTime;
    }

    public void setPct1ResTime(double pct1ResTime) {
        this.pct1ResTime = pct1ResTime;
    }

    public double getPct2ResTime() {
        return pct2ResTime;
    }

    public void setPct2ResTime(double pct2ResTime) {
        this.pct2ResTime = pct2ResTime;
    }

    public double getPct3ResTime() {
        return pct3ResTime;
    }

    public void setPct3ResTime(double pct3ResTime) {
        this.pct3ResTime = pct3ResTime;
    }

    public double getThroughput() {
        return throughput;
    }

    public void setThroughput(double throughput) {
        this.throughput = throughput;
    }

    public double getReceivedKBytesPerSec() {
        return receivedKBytesPerSec;
    }

    public void setReceivedKBytesPerSec(double receivedKBytesPerSec) {
        this.receivedKBytesPerSec = receivedKBytesPerSec;
    }

    public double getSentKBytesPerSec() {
        return sentKBytesPerSec;
    }

    public void setSentKBytesPerSec(double sentKBytesPerSec) {
        this.sentKBytesPerSec = sentKBytesPerSec;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Statistic{");
        sb.append("label='").append(label).append('\'');
        sb.append(", transaction='").append(transaction).append('\'');
        sb.append(", sampleCount=").append(sampleCount);
        sb.append(", errorCount=").append(errorCount);
        sb.append(", errorPct=").append(errorPct);
        sb.append(", meanResTime=").append(meanResTime);
        sb.append(", medianResTime=").append(medianResTime);
        sb.append(", minResTime=").append(minResTime);
        sb.append(", maxResTime=").append(maxResTime);
        sb.append(", pct1ResTime=").append(pct1ResTime);
        sb.append(", pct2ResTime=").append(pct2ResTime);
        sb.append(", pct3ResTime=").append(pct3ResTime);
        sb.append(", throughput=").append(throughput);
        sb.append(", receivedKBytesPerSec=").append(receivedKBytesPerSec);
        sb.append(", sentKBytesPerSec=").append(sentKBytesPerSec);
        sb.append('}');
        return sb.toString();
    }
}