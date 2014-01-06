package org.telegram.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import org.telegram.dao.GroupChat;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table GROUP_CHAT.
*/
public class GroupChatDao extends AbstractDao<GroupChat, Long> {

    public static final String TABLENAME = "GROUP_CHAT";

    /**
     * Properties of entity GroupChat.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "id", true, "_id");
        public final static Property Title = new Property(1, String.class, "title", false, "TITLE");
        public final static Property IsForbidden = new Property(2, Boolean.class, "isForbidden", false, "IS_FORBIDDEN");
        public final static Property Avatar = new Property(3, byte[].class, "avatar", false, "AVATAR");
        public final static Property IsLeftGroup = new Property(4, Boolean.class, "isLeftGroup", false, "IS_LEFT_GROUP");
        public final static Property UsersCount = new Property(5, Integer.class, "usersCount", false, "USERS_COUNT");
        public final static Property Users = new Property(6, byte[].class, "users", false, "USERS");
    };


    public GroupChatDao(DaoConfig config) {
        super(config);
    }
    
    public GroupChatDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'GROUP_CHAT' (" + //
                "'_id' INTEGER PRIMARY KEY NOT NULL ," + // 0: id
                "'TITLE' TEXT NOT NULL ," + // 1: title
                "'IS_FORBIDDEN' INTEGER," + // 2: isForbidden
                "'AVATAR' BLOB," + // 3: avatar
                "'IS_LEFT_GROUP' INTEGER," + // 4: isLeftGroup
                "'USERS_COUNT' INTEGER," + // 5: usersCount
                "'USERS' BLOB);"); // 6: users
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'GROUP_CHAT'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, GroupChat entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
        stmt.bindString(2, entity.getTitle());
 
        Boolean isForbidden = entity.getIsForbidden();
        if (isForbidden != null) {
            stmt.bindLong(3, isForbidden ? 1l: 0l);
        }
 
        byte[] avatar = entity.getAvatar();
        if (avatar != null) {
            stmt.bindBlob(4, avatar);
        }
 
        Boolean isLeftGroup = entity.getIsLeftGroup();
        if (isLeftGroup != null) {
            stmt.bindLong(5, isLeftGroup ? 1l: 0l);
        }
 
        Integer usersCount = entity.getUsersCount();
        if (usersCount != null) {
            stmt.bindLong(6, usersCount);
        }
 
        byte[] users = entity.getUsers();
        if (users != null) {
            stmt.bindBlob(7, users);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public GroupChat readEntity(Cursor cursor, int offset) {
        GroupChat entity = new GroupChat( //
            cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // title
            cursor.isNull(offset + 2) ? null : cursor.getShort(offset + 2) != 0, // isForbidden
            cursor.isNull(offset + 3) ? null : cursor.getBlob(offset + 3), // avatar
            cursor.isNull(offset + 4) ? null : cursor.getShort(offset + 4) != 0, // isLeftGroup
            cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5), // usersCount
            cursor.isNull(offset + 6) ? null : cursor.getBlob(offset + 6) // users
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, GroupChat entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setTitle(cursor.getString(offset + 1));
        entity.setIsForbidden(cursor.isNull(offset + 2) ? null : cursor.getShort(offset + 2) != 0);
        entity.setAvatar(cursor.isNull(offset + 3) ? null : cursor.getBlob(offset + 3));
        entity.setIsLeftGroup(cursor.isNull(offset + 4) ? null : cursor.getShort(offset + 4) != 0);
        entity.setUsersCount(cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5));
        entity.setUsers(cursor.isNull(offset + 6) ? null : cursor.getBlob(offset + 6));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(GroupChat entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(GroupChat entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}