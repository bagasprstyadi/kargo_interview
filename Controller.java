import java.util.*;
import java.io.*;

public class Controller  {

    static Map<String, List<Jobs>> jobsCache = new HashMap<String, List<Jobs>>();
    static Map<String, List<Jobs>> jobsCacheSortBudget = new HashMap<String, List<Jobs>>();
    static Map<String, List<Jobs>> jobsCacheSortOrigin = new HashMap<String, List<Jobs>>();
    static Map<String, List<Jobs>> jobsCacheSortDestination = new HashMap<String, List<Jobs>>();

    static List<User> userTable = new ArrayList<User>();
    static List<Jobs> jobsTable = new ArrayList<Jobs>();
    static List<ShippersJobs> shippersJobsTable = new ArrayList<ShippersJobs>();
    static List<Transporter> transporterTable = new ArrayList<Transporter>();
    static List<JobsBidding> jobsBiddingTable = new ArrayList<JobsBidding>();


    public static void main(String[] args) throws IOException {

        userTable.add(new User("shipper_hehe", "randomorg123", 0));
        userTable.add(new User("transporter_hehe", "random123", 1));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while((input = br.readLine()) != null ) {
            String input2[] = input.split(" ");
            if(input2[0].equals("ADD_JOBS")) {
                String user_id = input2[1];
                String jobs_origin = input2[2];
                String jobs_destination = input2[3];
                int budget = Integer.parseInt(input2[4]);
                String jobs_id = user_id + java.time.LocalDate.now();

                ShippersJobs inShippersJobs = new ShippersJobs(user_id, jobs_id);
                Jobs inJobs = new Jobs(jobs_id, 100, jobs_origin, jobs_destination, budget);

                shipperAddJobs(inShippersJobs, inJobs);
            } else if(input2[0].equals("FETCH_JOBS")) {
                String user_id = input2[1];
                int sort_id = Integer.parseInt(input2[2]);
                List<Jobs> res = fetchAllJobsOfShippers(0, user_id, sort_id);
                for(int i = 0; i < res.size(); i++) {
                    System.out.println(res.get(i));
                }
            }
        }
    }

    public static void shipperAddJobs(ShippersJobs sj, Jobs j) {
        shippersJobsTable.add(sj);
        jobsTable.add(j);

        jobsCache.put(sj.getUserID(), fetchAllJobsOfShippers(1, sj.getUserID(), 0));
        jobsCacheSortBudget.put(sj.getUserID(), fetchAllJobsOfShippers(1, sj.getUserID(), 1));
        jobsCacheSortDestination.put(sj.getUserID(), fetchAllJobsOfShippers(1, sj.getUserID(), 2));
        jobsCacheSortOrigin.put(sj.getUserID(), fetchAllJobsOfShippers(1, sj.getUserID(), 3));
    }

    public static List<Jobs> fetchAllJobsOfShippers(int requestID, String username, int sort_id) {
        List<Jobs> jobs = new ArrayList<Jobs>();
        if(requestID == 0 && jobsCache.get(username) != null && jobsCacheSortBudget.get(username) != null && 
            jobsCacheSortDestination.get(username) != null && jobsCacheSortOrigin.get(username) != null) {
            if(sort_id == 0) {
                return jobsCache.get(username);
            } else if(sort_id == 1) {
                return jobsCacheSortOrigin.get(username);
            } else if(sort_id == 2) {
                return jobsCacheSortDestination.get(username);
            } else {
                return jobsCacheSortBudget.get(username);
            }
        } else {
            for(int i = 0; i < shippersJobsTable.size(); i++) {
                if(shippersJobsTable.get(i).getUserID().equals(username)) {
                    for(int j = 0; j < jobsTable.size(); j++) {
                        if(jobsTable.get(i).getJobID().equals(shippersJobsTable.get(i).getJobID())) {
                            jobs.add(jobsTable.get(i));
                        }
                    }
                }
            }
        }

        DynamicJobsSort d = new DynamicJobsSort(0);
        Collections.sort(jobs, d.compareBy(sort_id));
        return jobs;
    }

    public static void transporterBid(Transporter t, long price) {

    }
}