public class ShippersJobs {

    private String user_id;
    private String job_id;

    public ShippersJobs(String user_id, String job_id){
        this.user_id = user_id;
        this.job_id = job_id;
    }

    public String getUserID() {
        return this.user_id;
    }

    public String getJobID() {
        return this.job_id;
    }
}