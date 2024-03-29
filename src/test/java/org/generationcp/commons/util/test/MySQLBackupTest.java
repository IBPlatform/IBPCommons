package org.generationcp.commons.util.test;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import org.generationcp.commons.util.MySQLUtil;
import org.junit.BeforeClass;
import org.junit.Test;

public class MySQLBackupTest {
    private static MySQLUtil mysqlBackup;
    
    private static File backupFile;
    
    @BeforeClass
    public static void setup() throws SQLException, ClassNotFoundException {
        mysqlBackup = new MySQLUtil();
        mysqlBackup.setMysqlDumpPath("C:/IBWorkflowSystem/infrastructure/mysql/bin/mysqldump.exe");
        mysqlBackup.setBackupDir(".");
        mysqlBackup.setMysqlDriver("com.mysql.jdbc.Driver");
        mysqlBackup.setMysqlHost("localhost");
        mysqlBackup.setMysqlPort(13306);
        mysqlBackup.setUsername("root");
    }

    @Test
    public void testBackupLocal() throws IOException, InterruptedException {
        backupFile = mysqlBackup.backupDatabase("ibdbv1_groundnut_local");
    }
    
    @Test
    public void testRestore() throws IOException, SQLException {
        mysqlBackup.restoreDatabase("ibdbv1_groundnut_local", backupFile);
    }
}
