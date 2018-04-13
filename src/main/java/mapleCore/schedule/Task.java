package mapleCore.schedule;

import org.joda.time.DateTime;



public class Task {

    /**
     * Task structure
     *
     * Title (title)
     * Date (mm/dd/yy) [hh/mm/ss]or[class] [extended] [hh/mm/ss]
     * Duration [hh/mm/ss]
     * Repeat [options]
     *
     * Task Description (desc)
     * Priority (priority)
     * Status (Status)
     */



    /** Priority constants */
    public static final int PRIORITY_LOW     = 0;
    public static final int PRIORITY_MED     = 1;
    public static final int PRIORITY_HIGH    = 2;

    /** Repeat constants */
    public static final int ONCE_ON_DAY      = 0;
    public static final int ONCE_ON_DAYS     = 1;
    public static final int REPEAT_ON_DAY    = 2;
    public static final int REPEAT_ON_DAYS   = 3;

    /** Status constants */
    public static final int PENDING          = 0;
    public static final int IN_PROGRESS      = 1;
    public static final int TERMINATED       = 2;




    private String taskTitle;

    private DateTime taskDateTime;

    private String taskDescription;

    private int taskPriority;

    private int taskStatus;





    public Task(){

    }






    public void setTaskDateTime(){

    }

    public void setTaskRepeat(){

    }

    public DateTime getTaskDateTime(){
        return null;

    }



}
