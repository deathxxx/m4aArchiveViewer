package kg.dengine.hararchive.viewer.hararchiveViewer.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "all", schema = "allsong", catalog = "Test")
public class AllEntity2 {
    private Long trackId;
    private Long artistId;
    private String displayArtist;
    private String displayTitle;
    private String track;
    private Integer voteUp;
    private Integer voteDown;
    private String style;
    private String styleAll;
    private Serializable styleAllArr;
    private Serializable json;
    private String folder;

    @Id
    @Column(name = "track_id")
    public Long getTrackId() {
        return trackId;
    }

    public void setTrackId(Long trackId) {
        this.trackId = trackId;
    }

    @Basic
    @Column(name = "artist_id")
    public Long getArtistId() {
        return artistId;
    }

    public void setArtistId(Long artistId) {
        this.artistId = artistId;
    }

    @Basic
    @Column(name = "display_artist")
    public String getDisplayArtist() {
        return displayArtist;
    }

    public void setDisplayArtist(String displayArtist) {
        this.displayArtist = displayArtist;
    }

    @Basic
    @Column(name = "display_title")
    public String getDisplayTitle() {
        return displayTitle;
    }

    public void setDisplayTitle(String displayTitle) {
        this.displayTitle = displayTitle;
    }

    @Basic
    @Column(name = "track")
    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    @Basic
    @Column(name = "vote_up")
    public Integer getVoteUp() {
        return voteUp;
    }

    public void setVoteUp(Integer voteUp) {
        this.voteUp = voteUp;
    }

    @Basic
    @Column(name = "vote_down")
    public Integer getVoteDown() {
        return voteDown;
    }

    public void setVoteDown(Integer voteDown) {
        this.voteDown = voteDown;
    }

    @Basic
    @Column(name = "style")
    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Basic
    @Column(name = "style_all")
    public String getStyleAll() {
        return styleAll;
    }

    public void setStyleAll(String styleAll) {
        this.styleAll = styleAll;
    }

    @Basic
    @Column(name = "style_all_arr")
    public Serializable getStyleAllArr() {
        return styleAllArr;
    }

    public void setStyleAllArr(Serializable styleAllArr) {
        this.styleAllArr = styleAllArr;
    }

    @Basic
    @Column(name = "json")
    public Serializable getJson() {
        return json;
    }

    public void setJson(Serializable json) {
        this.json = json;
    }

    @Basic
    @Column(name = "folder")
    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AllEntity2 that = (AllEntity2) o;

        if (trackId != null ? !trackId.equals(that.trackId) : that.trackId != null) return false;
        if (artistId != null ? !artistId.equals(that.artistId) : that.artistId != null) return false;
        if (displayArtist != null ? !displayArtist.equals(that.displayArtist) : that.displayArtist != null)
            return false;
        if (displayTitle != null ? !displayTitle.equals(that.displayTitle) : that.displayTitle != null) return false;
        if (track != null ? !track.equals(that.track) : that.track != null) return false;
        if (voteUp != null ? !voteUp.equals(that.voteUp) : that.voteUp != null) return false;
        if (voteDown != null ? !voteDown.equals(that.voteDown) : that.voteDown != null) return false;
        if (style != null ? !style.equals(that.style) : that.style != null) return false;
        if (styleAll != null ? !styleAll.equals(that.styleAll) : that.styleAll != null) return false;
        if (styleAllArr != null ? !styleAllArr.equals(that.styleAllArr) : that.styleAllArr != null) return false;
        if (json != null ? !json.equals(that.json) : that.json != null) return false;
        if (folder != null ? !folder.equals(that.folder) : that.folder != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = trackId != null ? trackId.hashCode() : 0;
        result = 31 * result + (artistId != null ? artistId.hashCode() : 0);
        result = 31 * result + (displayArtist != null ? displayArtist.hashCode() : 0);
        result = 31 * result + (displayTitle != null ? displayTitle.hashCode() : 0);
        result = 31 * result + (track != null ? track.hashCode() : 0);
        result = 31 * result + (voteUp != null ? voteUp.hashCode() : 0);
        result = 31 * result + (voteDown != null ? voteDown.hashCode() : 0);
        result = 31 * result + (style != null ? style.hashCode() : 0);
        result = 31 * result + (styleAll != null ? styleAll.hashCode() : 0);
        result = 31 * result + (styleAllArr != null ? styleAllArr.hashCode() : 0);
        result = 31 * result + (json != null ? json.hashCode() : 0);
        result = 31 * result + (folder != null ? folder.hashCode() : 0);
        return result;
    }
}
