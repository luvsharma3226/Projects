package listeners;

import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import utils.DBUtils;

/**
 * Application Lifecycle Listener implementation class DBConnectionManager
 *
 */
@WebListener
public class DBConnectionManager implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public DBConnectionManager() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
        try {
        	DBUtils.cleanUp();
		} catch (SQLException e) {
			System.out.println("err in ctx destroy "+e);
		}
    }

	

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("in ctx init");
		// create singleton instance of DB connection
		// how to get db config details : via ctx params
		// how to get ctx params : via servlet context
		// how to get servlet ctx : ServletContextEvent.getServletContext 
    	ServletContext ctx = sce.getServletContext();
    	try {
    		DBUtils.createSingletonDBConn(ctx.getInitParameter("drvr_cls"), ctx.getInitParameter("db_url"), ctx.getInitParameter("user_nm"), ctx.getInitParameter("password"));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
}
