package org.behive.com.workstream_platform.model.task;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Task {

    @SerializedName("branchId")
    @Expose
    private Integer branchId;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("dueDate")
    @Expose
    private String dueDate;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("priority")
    @Expose
    private Integer priority;
    @SerializedName("taskLocation")
    @Expose
    private TaskLocation taskLocation;
    @SerializedName("assigneeIds")
    @Expose
    private List<String> assigneeIds = null;
    @SerializedName("workspaceIds")
    @Expose
    private List<Integer> workspaceIds = null;
    @SerializedName("attachments")
    @Expose
    private List<Attachment> attachments = null;

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public TaskLocation getTaskLocation() {
        return taskLocation;
    }

    public void setTaskLocation(TaskLocation taskLocation) {
        this.taskLocation = taskLocation;
    }

    public List<String> getAssigneeIds() {
        return assigneeIds;
    }

    public void setAssigneeIds(List<String> assigneeIds) {
        this.assigneeIds = assigneeIds;
    }

    public List<Integer> getWorkspaceIds() {
        return workspaceIds;
    }

    public void setWorkspaceIds(List<Integer> workspaceIds) {
        this.workspaceIds = workspaceIds;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

}