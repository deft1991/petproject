package config;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author Vyacheslav Chernyshov
 * @date 21.11.17
 */
public class ResourcesProperties {

    /**
     * DATABASE
     */
    @Value("${db.driver}")
    private String dbDriver;

    @Value("${db.url}")
    private String dbUrl;

    @Value("${db.username}")
    private String dbUsername;

    @Value("${db.password}")
    private String dbPassword;

    @Value("#{T(java.lang.Integer).parseInt('${db.maxPoolSize}')}")
    private Integer dbMaxPoolSize;

    @Value("#{T(java.lang.Integer).parseInt('${db.minPoolSize}')}")
    private Integer dbMinPoolSize;

    @Value("#{T(java.lang.Integer).parseInt('${db.maxStatements}')}")
    private Integer dbMaxStatements;

    @Value("#{T(java.lang.Boolean).parseBoolean('${db.testConnection}')}")
    private Boolean dbTestConnection;

    @Value("${db.preferredTestQuery}")
    private String dbPreferredTestQuery;

    @Value("${hibernate.dialect}")
    private String dbDialect;

    @Value("#{T(java.lang.Boolean).parseBoolean('${hibernate.show_sql}')}")
    private Boolean dbShowSql;

    @Value("#{T(java.lang.Integer).parseInt('${hibernate.batch.size}')}")
    private Integer dbBatchSize;

    @Value("#{T(java.lang.Boolean).parseBoolean('${hibernate.format_sql}')}")
    private Boolean dbFormatSql;

    @Value("#{T(java.lang.Boolean).parseBoolean('${hibernate.use_sql_comments}')}")
    private Boolean dbUseSslComments;

    @Value("${entityManager.packages.toScan}")
    private String dbPackagesToScan;

    @Value("${hibernate.hbm2ddl.auto}")
    private String hbm2ddlAuto;

    /**
     * FILE STORAGE
     */
    @Value("${local.fs.path}")
    private String fsLocalPath;

    @Value("${db.csv.local.fs.path}")
    private String fsDbCsvLocalPath;

    @Value("${local.context.path}")
    private String fsLocalContextPath;

    @Value("#{T(java.lang.Integer).parseInt('${thumb.width')}")
    private Integer fsThumbWidth;

    @Value("#{T(java.lang.Integer).parseInt('${thumb.height}')}")
    private Integer fsThumbHeight;

    public String getDbDriver() {
        return dbDriver;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public String getDbUsername() {
        return dbUsername;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public Integer getDbMaxPoolSize() {
        return dbMaxPoolSize;
    }

    public Integer getDbMinPoolSize() {
        return dbMinPoolSize;
    }

    public Integer getDbMaxStatements() {
        return dbMaxStatements;
    }

    public Boolean getDbTestConnection() {
        return dbTestConnection;
    }

    public String getDbPreferredTestQuery() {
        return dbPreferredTestQuery;
    }

    public String getDbDialect() {
        return dbDialect;
    }

    public Boolean getDbShowSql() {
        return dbShowSql;
    }

    public Integer getDbBatchSize() {
        return dbBatchSize;
    }

    public Boolean getDbFormatSql() {
        return dbFormatSql;
    }

    public Boolean getDbUseSslComments() {
        return dbUseSslComments;
    }

    public String getDbPackagesToScan() {
        return dbPackagesToScan;
    }

    public String getHbm2ddlAuto() {
        return hbm2ddlAuto;
    }

    public String getFsLocalPath() {
        return fsLocalPath;
    }

    public String getFsDbCsvLocalPath() {
        return fsDbCsvLocalPath;
    }

    public String getFsLocalContextPath() {
        return fsLocalContextPath;
    }

    public Integer getFsThumbWidth() {
        return fsThumbWidth;
    }

    public Integer getFsThumbHeight() {
        return fsThumbHeight;
    }
}
