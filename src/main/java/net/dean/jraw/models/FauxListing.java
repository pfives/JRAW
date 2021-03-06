package net.dean.jraw.models;

import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * This class is a "hacky" way to represent a Listing
 * @param <T> The type of elements that will be in this listing
 */
public final class FauxListing<T extends RedditObject> extends Listing<T> {
    private final ImmutableList<T> children;
    private final String before;
    private final String after;
    private final String modhash;
    private final More more;

    /**
     * Instantiates a new FauxListing
     * @param children The children
     * @param before What comes before this listing
     * @param after What comes after this listing
     * @param modhash The modhash. May be null.
     */
    public FauxListing(List<T> children, String before, String after, String modhash) {
        this(children, before, after, modhash, null);
    }

    /**
     * Instantiates a new FauxListing
     * @param children The children
     * @param before What comes before this listing
     * @param after What comes after this listing
     * @param modhash The modhash. May be null.
     * @param more The More object for this listing
     */
    public FauxListing(List<T> children, String before, String after, String modhash, More more) {
        super(null, null);
        this.children = ImmutableList.<T>builder().addAll(children).build();
        this.before = before;
        this.after = after;
        this.more = more;
        this.modhash = modhash;
    }

    @Override
    protected ImmutableList<T> initChildren() {
        return children;
    }

    @Override
    protected More initMore() {
        return more;
    }

    @Override
    public ImmutableList<T> getChildren() {
        return children;
    }

    @Override
    public String getBefore() {
        return before;
    }

    @Override
    public String getAfter() {
        return after;
    }

    @Override
    public More getMoreChildren() {
        return more;
    }

    @Override
    public String getModhash() {
        return modhash;
    }
}
