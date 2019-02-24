package org.behive.com.workstream_platform.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LinkedTreeMap;

import org.behive.com.workstream_platform.utils.DbConstants;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = DbConstants.User.USER_TABLE_NAME)
public class User {

    @SerializedName("userId")
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = DbConstants.User.USER_ID)
    private String userId;

    @SerializedName("username")
    @ColumnInfo(name = DbConstants.User.USER_NAME)
    private String username;

    @SerializedName("password")
    @Ignore
    private String password;

    @SerializedName("emailConfirmed")
    @Ignore
    private Boolean emailConfirmed;

    @SerializedName("isActive")
    @Ignore
    private Boolean isActive;

    @SerializedName("firstName")
    @ColumnInfo(name = DbConstants.User.FIRST_NAME)
    private String firstName;

    @SerializedName("lastName")
    @ColumnInfo(name = DbConstants.User.LAST_NAME)
    private String lastName;

    @SerializedName("disconnectedAt")
    @Ignore
    private String disconnectedAt;

    @SerializedName("lastActionTime")
    @Ignore
    private String lastActionTime;

    @SerializedName("updatedDate")
    @Ignore
    private String updatedDate;

    @SerializedName("branchRoles")
    @Ignore
    private List<Object> branchRoles = null;

    public User() {
    }

    @Ignore
    public User(LinkedTreeMap<String, Object> map){
        this.userId = (String) map.get("userId");
        this.username = (String) map.get("username");
        this.emailConfirmed = (Boolean) map.get("emailConfirmed");
        this.isActive = (Boolean) map.get("isActive");
        this.firstName = (String) map.get("firstName");
        this.lastName = (String) map.get("lastName");
        this.disconnectedAt = (String) map.get("disconnectedAt");
        this.lastActionTime = (String) map.get("lastActionTime");
        this.updatedDate = (String) map.get("updatedDate");
        this.branchRoles = new ArrayList<>((List<Object>) map.get("branchRoles"));

    }

    @Ignore
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEmailConfirmed() {
        return emailConfirmed;
    }

    public void setEmailConfirmed(Boolean emailConfirmed) {
        this.emailConfirmed = emailConfirmed;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDisconnectedAt() {
        return disconnectedAt;
    }

    public void setDisconnectedAt(String disconnectedAt) {
        this.disconnectedAt = disconnectedAt;
    }

    public String getLastActionTime() {
        return lastActionTime;
    }

    public void setLastActionTime(String lastActionTime) {
        this.lastActionTime = lastActionTime;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public List<Object> getBranchRoles() {
        return branchRoles;
    }

    public void setBranchRoles(List<Object> branchRoles) {
        this.branchRoles = branchRoles;
    }


    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
