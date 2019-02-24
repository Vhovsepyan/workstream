package org.behive.com.workstream_platform.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import org.behive.com.workstream_platform.model.User;
import org.behive.com.workstream_platform.utils.DbConstants;

@Dao
public interface UserDao extends BaseDao<User> {

    @Query("SELECT * FROM "
            + DbConstants.User.USER_TABLE_NAME + " WHERE "
            + DbConstants.User.USER_ID + " = :userId")
    LiveData<User> getUserById(String userId);
}
