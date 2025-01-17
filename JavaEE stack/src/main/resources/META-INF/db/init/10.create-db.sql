-- start ESA_ARTISTS
create table if not exists ESA_ARTISTS (
    ID uuid primary key,
    NAME varchar(500) not null
);
-- end ESA_ARTISTS
-- start ESA_ALBUMS
create table if not exists ESA_ALBUMS (
    ID uuid primary key,
    NAME varchar(500) not null,
    YEAR int,
    GENRE varchar(500),
    LABEL varchar(500),
    ARTIST_ID uuid not null
);
-- end ESA_ALBUMS
-- start ESA_SONGS
create table if not exists ESA_SONGS(
    ID uuid primary key,
    NAME varchar(500) not null,
    EXPLICIT_CONTENT boolean,
    DURATION long,
    ALBUM_ID uuid,
    ARTIST_ID uuid not null
);
-- end ESA_SONGS