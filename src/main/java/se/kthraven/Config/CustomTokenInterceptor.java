package se.kthraven.Config;

import jakarta.annotation.Priority;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

@Provider
@Priority(Priorities.AUTHENTICATION)
public class CustomTokenInterceptor implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws WebApplicationException {
        String customToken = requestContext.getHeaderString("Authorization");

        if (isValidToken(customToken)) {
            return;
        }

        requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
    }

    private boolean isValidToken(String token) {
        if(token == null)
            return false;
        String[] tokenParts = token.split(" ");
        tokenParts = tokenParts[1].split(":");
        if(tokenParts.length < 2)
            return false;
        return (tokenParts[2].equals("ROLE_DOCTOR") || tokenParts[2].equals("ROLE_OTHER"));
    }
}

