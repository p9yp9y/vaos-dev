package git;

import java.io.File;
import java.util.Arrays;

import org.apache.maven.shared.invoker.DefaultInvocationRequest;
import org.apache.maven.shared.invoker.DefaultInvoker;
import org.apache.maven.shared.invoker.InvocationRequest;
import org.apache.maven.shared.invoker.Invoker;
import org.apache.maven.shared.invoker.MavenInvocationException;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;
import org.junit.Test;

public class JGitTest {
	@Test
	public void testClone() throws InvalidRemoteException, TransportException, GitAPIException, MavenInvocationException {
		Git git = Git.cloneRepository().setURI("https://github.com/p9yp9y/vaos-hello-app.git").call();
		InvocationRequest request = new DefaultInvocationRequest();
		request.setPomFile( new File( "vaos-hello-app/pom.xml" ) );
		request.setGoals( Arrays.asList( "clean", "install" ) );

		Invoker invoker = new DefaultInvoker();
		invoker.execute( request );
	}
}
