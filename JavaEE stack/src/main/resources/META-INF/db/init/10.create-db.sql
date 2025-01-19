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

-- start ESA_ALBUMS
alter table ESA_ALBUMS add constraint FK_ESA_ALBUMS_ARTISTS foreign key (ARTIST_ID) references ESA_ARTISTS(ID)
-- end ESA_ALBUMS
-- start ESA_SONGS
alter table ESA_SONGS add constraint FK_ESA_SONGS_ARTISTS foreign key (ARTIST_ID) references ESA_ARTISTS(ID)
alter table ESA_SONGS add constraint FK_ESA_SONGS_ALBUMS foreign key (ALBUM_ID) references ESA_ALBUMS(ID)
-- end ESA_SONGS