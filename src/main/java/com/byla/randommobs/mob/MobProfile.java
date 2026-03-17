package com.byla.randommobs.mob;

import com.byla.randommobs.tag.TagMob;
import java.util.Set;

public class MobProfile {

    private final Set<TagMob> tags;
    private final MobStats stats;

    public MobProfile(Set<TagMob> tags, MobStats stats) {
        this.tags = tags;
        this.stats = stats;
    }

    public boolean temTag (TagMob tag) {return tags.contains(tag);}

    public Set<TagMob> getTags() {return tags;}

    public MobStats getStats() {return stats;}
}
