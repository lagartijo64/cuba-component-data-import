package de.diedavids.cuba.dataimport.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.core.entity.FileDescriptor;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import java.util.List;
import javax.persistence.OneToMany;

@Table(name = "DDCDI_IMPORT_LOG")
@Entity(name = "ddcdi$ImportLog")
public class ImportLog extends StandardEntity {
    private static final long serialVersionUID = -2901352797679880851L;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "FILE_ID")
    protected FileDescriptor file;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "importLog")
    protected List<ImportLogRecord> records;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "STARTED_AT")
    protected Date startedAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FINISHED_AT")
    protected Date finishedAt;

    @Column(name = "ENTITIES_PROCESSED")
    protected Integer entitiesProcessed;




    @Column(name = "ENTITIES_IMPORT_SUCCESS")
    protected Integer entitiesImportSuccess;

    @Column(name = "ENTITIES_IMPORT_VAL_ERROR")
    protected Integer entitiesImportValidationError;

    @Column(name = "ENTITIES_PRE_COMMIT_SKIPPED")
    protected Integer entitiesPreCommitSkipped;

    @Column(name = "ENTITIES_UNIQUE_CONSTRAINT_SKIPPED")
    protected Integer entitiesUniqueConstraintSkipped;

    @NotNull
    @Column(name = "SUCCESS", nullable = false)
    protected Boolean success = false;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CONFIGURATION_ID")
    protected ImportConfiguration configuration;

    public void setEntitiesUniqueConstraintSkipped(Integer entitiesUniqueConstraintSkipped) {
        this.entitiesUniqueConstraintSkipped = entitiesUniqueConstraintSkipped;
    }

    public Integer getEntitiesUniqueConstraintSkipped() {
        return entitiesUniqueConstraintSkipped;
    }


    public void setEntitiesPreCommitSkipped(Integer entitiesPreCommitSkipped) {
        this.entitiesPreCommitSkipped = entitiesPreCommitSkipped;
    }

    public Integer getEntitiesPreCommitSkipped() {
        return entitiesPreCommitSkipped;
    }


    public void setEntitiesImportSuccess(Integer entitiesImportSuccess) {
        this.entitiesImportSuccess = entitiesImportSuccess;
    }

    public Integer getEntitiesImportSuccess() {
        return entitiesImportSuccess;
    }

    public void setEntitiesImportValidationError(Integer entitiesImportValidationError) {
        this.entitiesImportValidationError = entitiesImportValidationError;
    }

    public Integer getEntitiesImportValidationError() {
        return entitiesImportValidationError;
    }


    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Boolean getSuccess() {
        return success;
    }


    public void setConfiguration(ImportConfiguration configuration) {
        this.configuration = configuration;
    }

    public ImportConfiguration getConfiguration() {
        return configuration;
    }


    public void setRecords(List<ImportLogRecord> records) {
        this.records = records;
    }

    public List<ImportLogRecord> getRecords() {
        return records;
    }


    public void setEntitiesProcessed(Integer entitiesProcessed) {
        this.entitiesProcessed = entitiesProcessed;
    }

    public Integer getEntitiesProcessed() {
        return entitiesProcessed;
    }


    public void setFile(FileDescriptor file) {
        this.file = file;
    }

    public FileDescriptor getFile() {
        return file;
    }

    public void setStartedAt(Date startedAt) {
        this.startedAt = startedAt;
    }

    public Date getStartedAt() {
        return startedAt;
    }

    public void setFinishedAt(Date finishedAt) {
        this.finishedAt = finishedAt;
    }

    public Date getFinishedAt() {
        return finishedAt;
    }


}