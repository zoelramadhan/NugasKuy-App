package elite.models;


public class Task {
    private String judulTugas;
    private String tag;
    private String label;
    private String deadline;
    private boolean isFinish;

    public boolean isFinish() {
        return isFinish;
    }

    public Task(String judulTugas, String tag, String label, String deadline) {
        this.judulTugas = judulTugas;
        this.tag = tag;
        this.label = label;
        this.deadline = deadline;
        this.isFinish = false;
    }

    public void finishTask(){
        isFinish = true;
    }

    public String getJudulTugas() {
        return judulTugas;
    }

    public void setJudulTugas(String judulTugas) {
        this.judulTugas = judulTugas;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}
