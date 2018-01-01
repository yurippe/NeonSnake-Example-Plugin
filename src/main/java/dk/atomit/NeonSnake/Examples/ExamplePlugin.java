package dk.atomit.NeonSnake.Examples;

import dk.atomit.NeonSnake.Dependencies.Provider;
import dk.atomit.NeonSnake.NeonPlugins.NeonPlugin;
import dk.atomit.NeonSnake.REST.RESTPluginListener;
import dk.atomit.NeonSnake.REST.RESTPluginManager;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * @author Kristian Gausel
 *
 * Example NeonPlugin
 */
public class ExamplePlugin implements NeonPlugin, RESTPluginListener {

    Provider provider;

    @Override
    public void start(Provider provider) {
        this.provider = provider;
        provider.getLogger().info("Called start in External ExamplePlugin");

        provider.getDependencyResolver().resolve(RESTPluginManager.class).registerListener("external", this);

    }

    @Override
    public void stop() {
        provider.getLogger().info("Called stop in External ExamplePlugin");
    }

    /*
        NOTE: The methods from RESTPluginListener are NOT synchronized, they are called from seperate threads, thus
        any fields / data they use should be synchronized or they should be pure functions.
     */

    @Override
    public Response onGET(ServletContext context, HttpServletRequest request, UriInfo uriInfo) {
        provider.getLogger().info("GET on plugin/external");
        return Response.ok().entity("OK").build();
    }

    @Override
    public Response onPOST(ServletContext context, HttpServletRequest request, UriInfo uriInfo, String body) {
        provider.getLogger().info("POST on plugin/external with data " + body);
        return Response.ok().entity("OK").build();
    }

    @Override
    public Response onPUT(ServletContext context, HttpServletRequest request, UriInfo uriInfo, String body) {
        provider.getLogger().info("PUT on plugin/external with data " + body);
        return Response.ok().entity("OK").build();
    }

    @Override
    public Response onDELETE(ServletContext context, HttpServletRequest request, UriInfo uriInfo, String body) {
        provider.getLogger().info("DELETE on plugin/external with data " + body);
        return Response.ok().entity("OK").build();
    }
}