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

        taskTitle = "Untitled Task";

        taskDateTime = DateTime.now();

        taskDescription = "No description";

        taskPriority = PRIORITY_LOW;

        taskStatus = PENDING;

    }

    public Task(String taskTitle){
        this();

        this.taskTitle = taskTitle;

    }

    public Task(String taskTitle, DateTime taskDateTime){
        this(taskTitle);

        this.taskDateTime = taskDateTime;

    }

    public Task(String taskTitle, DateTime taskDateTime, String taskDescription){
        this(taskTitle, taskDateTime);

        this.taskDescription = taskDescription;

    }

    public Task(String taskTitle, DateTime taskDateTime, String taskDescription, int taskPriority){
        this(taskTitle, taskDateTime, taskDescription);

        this.taskPriority = taskPriority;
    }

    public Task(String taskTitle, DateTime taskDateTime, String taskDescription, int taskPriority, int taskStatus){
        this(taskTitle, taskDateTime, taskDescription, taskPriority);

        this.taskStatus = taskStatus;
    }







    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }




    public DateTime getTaskDateTime() {
        return taskDateTime;
    }

    public void setTaskDateTime(DateTime taskDateTime) {
        this.taskDateTime = taskDateTime;
    }




    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }




    public int getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(int taskPriority) {
        this.taskPriority = taskPriority;
    }




    public int getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(int taskStatus) {
        this.taskStatus = taskStatus;
    }









}
