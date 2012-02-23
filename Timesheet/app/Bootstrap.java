import Utils.HolidayTypeUtil;
import play.test.*;
import play.jobs.*;
import models.*;

@OnApplicationStart
public class Bootstrap extends Job {
    
    public void doJob() {
        // Load default data if the database is empty
        if(Team.count() == 0) {
            System.out.println("############ Loaded yml" + Team.count());
            Fixtures.loadModels("initial-data.yml");
            System.out.println("############ Loaded yml END" + Team.count());

        }
        HolidayTypeUtil.initIfReqiured();
    }
    
}