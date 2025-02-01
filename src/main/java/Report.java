class Report {
    private int reportID;
    private String type;
    private String data;

    public Report(int reportID, String type, String data) {
        this.reportID = reportID;
        this.type = type;
        this.data = data;
    }

    public void generateReport() {
        System.out.println("Report Generated: " + data);
    }

    public int getReportID() {
        return reportID;
    }

    public String getType() {
        return type;
    }

    public String getData() {
        return data;
    }
}
