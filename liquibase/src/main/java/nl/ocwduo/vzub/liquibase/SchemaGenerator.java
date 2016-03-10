package nl.ocwduo.vzub.liquibase;

import nl.ocwduo.vzub.domain.model.file.File;
import nl.ocwduo.vzub.domain.model.file.details.FileLock;
import nl.ocwduo.vzub.domain.model.file.details.FileSpecs;
import nl.ocwduo.vzub.domain.model.file.details.FileStatus;
import nl.ocwduo.vzub.domain.model.fileType.FileType;
import nl.ocwduo.vzub.domain.model.fileType.details.EmailNotification;
import nl.ocwduo.vzub.domain.model.fileType.details.FileTimeManagement;
import nl.ocwduo.vzub.domain.model.fileType.details.GftKanaal;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
/**
 * Utility class om create_table.sql te maken.
 * Uitvoer bestand staat in "target/generated/sql/create_tables.sql" (hard-gecodeerd)
 * De main verwacht geen argumenten, controleert er niet op en gebruikt ze ook niet.
 * De class genereert per statement een ";" op het einde. Dat is nodig voor AS400 DB.
 *
 * @author Tsjisse Tilma (in575til)
 * @author Jan Karel Valkema (in085val)
 */
public class SchemaGenerator {
    /**
     * Private constructor om te voorkomen dat er instanties worden aangemaakt.
     * Geen singleton, alleen static functies
     */
    private SchemaGenerator() {
        // niets te initialiseren
    }

    public static void main(String[] args) throws Exception {
        Configuration cfg;
        cfg = new Configuration();
        cfg.setProperty("hibernate.hbm2ddl.auto", "create");
        cfg.addAnnotatedClass(File.class);
        cfg.addAnnotatedClass(FileLock.class);
        cfg.addAnnotatedClass(FileSpecs.class);
        cfg.addAnnotatedClass(FileStatus.class);
        cfg.addAnnotatedClass(FileType.class);
        cfg.addAnnotatedClass(EmailNotification.class);
        cfg.addAnnotatedClass(FileTimeManagement.class);
        cfg.addAnnotatedClass(GftKanaal.class);
        cfg.setProperty(AvailableSettings.DIALECT, "org.hibernate.dialect.DB2400Dialect");
        SchemaExport export = new SchemaExport(cfg);
        //new EnversSchemaGenerator(cfg).export();
        //Files.createDirectories(Paths.get("target/generated/sql"));
        export.setFormat(true); // elk veld mooi op aparte regel
        //export.setFormat(false); // plaatst elk sql statement op 1 regel
        export.setOutputFile("D:/create_tables.sql");
        export.setDelimiter(";");
        export.execute(true, false, false, true);
        System.out.println("Exported");
    }
}
