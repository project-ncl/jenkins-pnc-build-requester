package com.redhat.jenkins.plugins.buildrequester;

import hudson.Extension;
import hudson.model.AbstractBuild;
import hudson.model.Action;
import jenkins.model.TransientActionFactory;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.Collections;

/**
 * @author vdedik@redhat.com
 */
@Extension
public class BuildRequesterActionFactory extends TransientActionFactory {
    @Override
    public Class type() {
        return AbstractBuild.class;
    }

    @Nonnull
    @Override
    public Collection<? extends Action> createFor(Object build) {
        BuildRequesterAction action = new BuildRequesterAction();
        action.setBuild((AbstractBuild) build);
        return Collections.singleton(action);
    }
}