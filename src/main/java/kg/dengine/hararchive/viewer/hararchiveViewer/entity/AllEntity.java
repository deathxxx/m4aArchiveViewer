package kg.dengine.hararchive.viewer.hararchiveViewer.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "all", schema = "allsong", catalog = "Test")
public class AllEntity {
    private Long trackId;
    private Long artistId;
    private String displayArtist;
    private String displayTitle;
    private String track;
    private Integer voteUp;
    private Integer voteDown;
    private String style;
    private String styleAll;
    private String json;

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
    @Column(name = "json")
    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllEntity allEntity = (AllEntity) o;
        return Objects.equals(trackId, allEntity.trackId) &&
                Objects.equals(artistId, allEntity.artistId) &&
                Objects.equals(displayArtist, allEntity.displayArtist) &&
                Objects.equals(displayTitle, allEntity.displayTitle) &&
                Objects.equals(track, allEntity.track) &&
                Objects.equals(voteUp, allEntity.voteUp) &&
                Objects.equals(voteDown, allEntity.voteDown) &&
                Objects.equals(style, allEntity.style) &&
                Objects.equals(styleAll, allEntity.styleAll) &&
                Objects.equals(json, allEntity.json);
    }

    @Override
    public int hashCode() {

        return Objects.hash(trackId, artistId, displayArtist, displayTitle, track, voteUp, voteDown, style, styleAll, json);
    }
}
