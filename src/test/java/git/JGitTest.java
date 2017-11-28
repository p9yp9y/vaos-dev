package git;

import org.apache.maven.cli.MavenCli;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;
import org.junit.Test;

public class JGitTest {

	@Test
	public void testClone() throws InvalidRemoteException, TransportException, GitAPIException {
		
		//Git git = Git.cloneRepository().setURI("https://github.com/p9yp9y/vaos-dev.git").call();

		System.setProperty("maven.multiModuleProjectDirectory", "/home/andris/Desktop/maven_home/");
		MavenCli cli = new MavenCli();
		cli.doMain(new String[]{"install", "-DskipTests"}, "/home/andris/workspace3/vaos-dev/vaos-dev", System.out, System.err);
	}
}
