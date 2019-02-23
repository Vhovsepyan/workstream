package org.behive.com.workstream_platform.model.task;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Task {

    @SerializedName("taskId")
    @Expose
    private Integer taskId;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("oldStatus")
    @Expose
    private Integer oldStatus;
    @SerializedName("priority")
    @Expose
    private Integer priority;
    @SerializedName("creatorId")
    @Expose
    private String creatorId;
    @SerializedName("creator")
    @Expose
    private Creator creator;
    @SerializedName("branchId")
    @Expose
    private Integer branchId;
    @SerializedName("isOverdue")
    @Expose
    private Boolean isOverdue;
    @SerializedName("isSeen")
    @Expose
    private Boolean isSeen;
    @SerializedName("canChange")
    @Expose
    private Boolean canChange;
    @SerializedName("assignees")
    @Expose
    private List<Object> assignees = null;
    @SerializedName("workspaces")
    @Expose
    private List<Object> workspaces = null;
    @SerializedName("attachments")
    @Expose
    private List<Object> attachments = null;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOldStatus() {
        return oldStatus;
    }

    public void setOldStatus(Integer oldStatus) {
        this.oldStatus = oldStatus;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public Creator getCreator() {
        return creator;
    }

    public void setCreator(Creator creator) {
        this.creator = creator;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public Boolean getIsOverdue() {
        return isOverdue;
    }

    public void setIsOverdue(Boolean isOverdue) {
        this.isOverdue = isOverdue;
    }

    public Boolean getIsSeen() {
        return isSeen;
    }

    public void setIsSeen(Boolean isSeen) {
        this.isSeen = isSeen;
    }

    public Boolean getCanChange() {
        return canChange;
    }

    public void setCanChange(Boolean canChange) {
        this.canChange = canChange;
    }

    public List<Object> getAssignees() {
        return assignees;
    }

    public void setAssignees(List<Object> assignees) {
        this.assignees = assignees;
    }

    public List<Object> getWorkspaces() {
        return workspaces;
    }

    public void setWorkspaces(List<Object> workspaces) {
        this.workspaces = workspaces;
    }

    public List<Object> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Object> attachments) {
        this.attachments = attachments;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", oldStatus=" + oldStatus +
                ", priority=" + priority +
                ", creatorId='" + creatorId + '\'' +
                ", creator=" + creator +
                ", branchId=" + branchId +
                ", isOverdue=" + isOverdue +
                ", isSeen=" + isSeen +
                ", canChange=" + canChange +
                ", assignees=" + assignees +
                ", workspaces=" + workspaces +
                ", attachments=" + attachments +
                '}';
    }
}