package com.azubal.todoc.model;




import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Comparator;

import static androidx.room.ForeignKey.CASCADE;


@Entity(tableName = "tasks",
        foreignKeys = @ForeignKey(entity = Project.class,
                parentColumns = "id",
                childColumns = "project_id",
                onDelete = CASCADE))
public class Task {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "project_id", index = true)
    private long projectId;

    @SuppressWarnings("NullableProblems")
    private String name;

    private long creationTimestamp;

    public Task(long projectId, @NonNull String name, long creationTimestamp) {
        this.setProjectId(projectId);
        this.setName(name);
        this.setCreationTimestamp(creationTimestamp);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    @Nullable
    public Project getProject() {
        return Project.getProjectById(projectId);
    }

    @NonNull
    public String getName() {
        return name;
    }

    private void setName(@NonNull String name) {
        this.name = name;
    }

    private void setCreationTimestamp(long creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public long getProjectId() {
        return projectId;
    }

    public long getCreationTimestamp() {
        return creationTimestamp;
    }

}