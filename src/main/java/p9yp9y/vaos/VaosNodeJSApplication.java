package p9yp9y.vaos;

import java.io.IOException;

import org.eclipse.jgit.api.errors.GitAPIException;

import p9yp9y.vaos.io.GitUtil;

public abstract class VaosNodeJSApplication implements VaosApplication {
	@Override
	public final void main(String[] args) {
		try {
			String url = "https://github.com/p9yp9y/vaos-nodejs.git";
			String[] mvnArgs = new String[] { "nodejs:run", "-DmoduleName=" + getModuleName(), "-DnodeJSArgument='" + getNodeJSArgument() + "'" };
			GitUtil.build(url, mvnArgs);
		} catch (IOException | GitAPIException e) {
			e.printStackTrace();
		}
	}

	public abstract String getModuleName();

	public abstract String getNodeJSArgument();
}