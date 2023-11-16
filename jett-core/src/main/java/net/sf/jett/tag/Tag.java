package net.sf.jett.tag;

import net.sf.jett.model.WorkbookContext;
import org.apache.poi.ss.usermodel.RichTextString;

import java.util.Map;

/**
 * <p>A <code>Tag</code> represents an XML tag that can reside in a
 * <code>Cell</code>.  A <code>Tag</code> represents special processing inside
 * its own <code>Block</code> of <code>Cells</code> (the tag "body").  Each
 * <code>Tag</code> is responsible for processing its own <code>Block</code>.</p>
 *
 * <p>Any concrete subclass of <code>Tag</code> must have a public, no-argument
 * constructor.</p>
 *
 * @author Randy Gettman
 */
public interface Tag
{
    /**
     * Returns the name of the <code>Tag</code>.
     * @return The name of the <code>Tag</code>.
     */
	String getName();

    /**
     * When a <code>Tag</code> is created, the attributes are passed in via a
     * (possibly empty) <code>Map</code> of attribute names and values.
     * @param attributes A <code>Map</code> of attribute names and values.
     */
	void setAttributes(Map<String, RichTextString> attributes);

    /**
     * Sets whether this <code>Tag</code> is bodiless.
     * @param bodiless <code>true</code> if this tag does not have a body,
     *    <code>false</code> if this tag does have a body.
     */
	void setBodiless(boolean bodiless);

    /**
     * Returns whether this <code>Tag</code> is bodiless.
     * @return <code>true</code> if this tag does not have a body,
     *    <code>false</code> if this tag does have a body.
     */
	boolean isBodiless();

    /**
     * A <code>Tag</code> can retrieve its attributes by calling this method.
     * @return A <code>Map</code> of attribute names and attribute values.
     */
	Map<String, RichTextString> getAttributes();

    /**
     * Sets the <code>TagContext</code> to which the <code>Tag</code> is
     * associated.
     * @param context A <code>TagContext</code>.
     */
	void setContext(TagContext context);

    /**
     * Returns the <code>TagContext</code> to which the <code>Tag</code> is
     * associated.
     * @return The associated <code>TagContext</code>.
     */
	TagContext getContext();

    /**
     * Sets the <code>WorkbookContext</code> to which the <code>Tag</code> is
     * associated.
     * @param context A <code>WorkbookContext</code>.
     */
	void setWorkbookContext(WorkbookContext context);

    /**
     * Returns the <code>WorkbookContext</code> to which the <code>Tag</code> is
     * associated.
     * @return The associated <code>WorkbookContext</code>.
     */
	WorkbookContext getWorkbookContext();

    /**
     * Sets the parent <code>Tag</code> to this <code>Tag</code>.  The parent
     * tag is the tag that encloses this tag in the template spreadsheet.
     * @param parent The parent <code>Tag</code>, or <code>null</code> if none.
     * @since 0.9.0
     */
	void setParentTag(Tag parent);

    /**
     * Returns the parent <code>Tag</code> to this <code>Tag</code>.  The parent
     * tag is the tag that encloses this tag in the template spreadsheet.
     * @return The parent <code>Tag</code>, or <code>null</code> if none.
     * @since 0.9.0
     */
	Tag getParentTag();

    /**
     * <p>Validates all attributes and attribute values.  Processes this
     * <code>Tag</code>.</p>
     * <p>For 0.3.0, the methods "checkAttributes" and "process" were removed
     * and replace by this method, to allow for additional logic.  The methods
     * still exist in <code>BaseTag</code>, where they are called by a concrete
     * <code>processTag</code> method.</p>
     * @return <code>true</code> if the <code>Cell</code> containing this
     *    <code>Tag</code> was transformed, <code>false</code> if it needs to be
     *    transformed again.  This may happen if the <code>Block</code>
     *    associated with the <code>Tag</code> was removed.
     * @throws net.sf.jett.exception.TagParseException If all required
     *    attributes are not present, if there is an unrecognized attribute or
     *    attribute value, or if any tag data is unacceptable in any other way.
     * @since 0.3.0
     */
	boolean processTag();
}

