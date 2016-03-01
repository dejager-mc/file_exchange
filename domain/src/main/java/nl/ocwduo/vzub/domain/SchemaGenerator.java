//package nl.ocwduo.vzub;
//
//import org.hibernate.cfg.AnnotationConfiguration;
//import org.hibernate.tool.hbm2ddl.SchemaExport;
//
//import java.io.File;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author john.thompson
// */
//public class SchemaGenerator {
//    private AnnotationConfiguration cfg;
//
//    public SchemaGenerator(String packageName) throws Exception {
//        cfg = new AnnotationConfiguration();
//        cfg.setProperty("hibernate.hbm2ddl.auto", "create");
//
//        for (Class<Object> clazz : getClasses(packageName)) {
//            System.out.println("adding class: " + clazz.getCanonicalName());
//            cfg.addAnnotatedClass(clazz);
//        }
//    }
//
//    /**
//     * Method that actually creates the file.
//     *
//     * @param dbDialect to use
//     */
//    private void generate(Dialect dialect) {
//        cfg.setProperty("hibernate.dialect", dialect.getDialectClass());
//
//        SchemaExport export = new SchemaExport(cfg);
//        export.setDelimiter(";");
//        export.setOutputFile("ddl_" + dialect.name().toLowerCase() + ".sql");
//        export.execute(true, false, false, false);
//    }
//
//    /**
//     * @param args
//     */
//    public static void main(String[] args) throws Exception {
//        SchemaGenerator gen = new SchemaGenerator("nl.ocwduo.vzub.domain");
////        gen.generate(Dialect.MYSQL);
////        gen.generate(Dialect.ORACLE);
//        gen.generate(Dialect.HSQL);
//    }
//
//    /**
//     * Utility method used to fetch Class list based on a package name.
//     * @param packageName (should be the package containing your annotated beans.
//     */
//    private List<Class> getClasses(String packageName) throws Exception {
//        System.out.println("finding files");
//        List<Class> classes = new ArrayList<Class>();
//        File directory = null;
//        try {
//            ClassLoader cld = Thread.currentThread().getContextClassLoader();
//            if (cld == null) {
//                throw new ClassNotFoundException("Can't get class loader.");
//            }
//            String path = packageName.replace('.', '/');
//            URL resource = cld.getResource(path);
//            if (resource == null) {
//                throw new ClassNotFoundException("No resource for " + path);
//            }
//            directory = new File(resource.getFile());
//        } catch (NullPointerException x) {
//            throw new ClassNotFoundException(packageName + " (" + directory
//                    + ") does not appear to be a valid package");
//        }
//        if (directory.exists()) {
//            System.out.println("package exists");
//            String[] files = directory.list();
//            System.out.println("list of files: ");
//            for (int i = 0; i < files.length; i++) {
//                System.out.println("adding class: " + files[i]);
//                if (files[i].endsWith(".class")) {
//                    // removes the .class extension
//                    System.out.println("adding class: " + files[i]);
//                    classes.add(Class.forName(packageName + '.'
//                            + files[i].substring(0, files[i].length() - 6)));
//                }
//            }
//        } else {
//            throw new ClassNotFoundException(packageName
//                    + " is not a valid package");
//        }
//
//        return classes;
//    }
//
//    /**
//     * Holds the classnames of hibernate dialects for easy reference.
//     */
//    private static enum Dialect {
////        ORACLE("org.hibernate.dialect.Oracle10gDialect"),
////        MYSQL("org.hibernate.dialect.MySQLDialect"),
//        HSQL("org.hibernate.dialect.HSQLDialect");
//
//        private String dialectClass;
//
//        private Dialect(String dialectClass) {
//            this.dialectClass = dialectClass;
//        }
//
//        public String getDialectClass() {
//            return dialectClass;
//        }
//    }
//}
