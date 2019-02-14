public class Jobs {

    private String job_id;
    private int distance;
    private String origin;
    private String destination;
    private int budget;

    public Jobs(String job_id, int distance, String origin, String destination, int budget) {
        this.job_id = job_id;
        this.distance = distance;
        this.origin = origin;
        this.destination = destination;
        this.budget = budget;
    }

    public String getJobID() {
        return this.job_id;
    }

    public int getDistance() {
        return this.distance;
    }

    public String getOrigin() {
        return this.origin;
    }

    public String getDestination() {
        return this.destination;
    }

    public int getBudget() {
        return this.budget;
    }

    @Override
    public String toString() {
        return "{" + this.job_id + ", " + this.distance + ", " + this.origin + ", " + this.destination + ", " + this.budget + "}";
    }

}