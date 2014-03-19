CREATE SCHEMA `darkroom` ;
USE `darkroom`;

CREATE TABLE `userIDs` (
  `email` varchar(255) NOT NULL,
  `userID` int(64) NOT NULL,
  `password` varchar(1024) NOT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `user` (
  `displayname` varchar(25) NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `userID` int(64) NOT NULL,
  `is_authenticated` bit(1) NOT NULL DEFAULT b'0',
  `about` varchar(2048) DEFAULT NULL,
  `style` varchar(1024) DEFAULT NULL,
  `equipment` varchar(2048) DEFAULT NULL,
  `for_hire` bit(1) NOT NULL DEFAULT b'0',
  `work_interests` varchar(2048) DEFAULT NULL,
  `website` varchar(1024) DEFAULT NULL,
  `reviews_allowed` bit(1) DEFAULT b'1',
  `guestbook_allowed` bit(1) DEFAULT b'1',
  `comments_allowed` bit(1) NOT NULL DEFAULT b'1',
  PRIMARY KEY (`userID`),
  UNIQUE KEY `email_UNIQUE` (`userID`),
  CONSTRAINT `user_userID` FOREIGN KEY (`userID`) REFERENCES `userIDs` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `files` (
  `fileid` int(64) NOT NULL,
  `filename` varchar(45) NOT NULL,
  `userid` int(64) NOT NULL,
  `width` int(11) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `filetype` varchar(10) NOT NULL,
  `file_location` varchar(256) NOT NULL,
  `description` varchar(2048) DEFAULT NULL,
  `time_uploaded` datetime NOT NULL,
  `time_taken` datetime DEFAULT NULL,
  `total_views` int(45) NOT NULL DEFAULT '0',
  `ratings_allowed` bit(1) NOT NULL DEFAULT b'1',
  `comments_allowed` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`fileid`),
  UNIQUE KEY `fileid_UNIQUE` (`fileid`),
  KEY `fileOwner_idx` (`userid`),
  CONSTRAINT `fileOwner` FOREIGN KEY (`userid`) REFERENCES `user` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `galleries` (
  `galleryID` int(64) NOT NULL,
  `ownerID` int(64) NOT NULL,
  `name` varchar(128) NOT NULL,
  `description` varchar(2048) DEFAULT NULL,
  PRIMARY KEY (`galleryID`),
  UNIQUE KEY `galleryID_UNIQUE` (`galleryID`),
  KEY `galleryOwner_idx` (`ownerID`),
  CONSTRAINT `galleryOwner` FOREIGN KEY (`ownerID`) REFERENCES `user` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `galleryFiles` (
  `relationID` int(128) NOT NULL,
  `galleryID` int(64) NOT NULL,
  `fileID` int(64) NOT NULL,
  PRIMARY KEY (`relationID`),
  UNIQUE KEY `relationID_UNIQUE` (`relationID`),
  KEY `galleryFilesGallery_idx` (`galleryID`),
  KEY `galleryFilesFile_idx` (`fileID`),
  CONSTRAINT `galleryFilesGallery` FOREIGN KEY (`galleryID`) REFERENCES `galleries` (`galleryID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `galleryFilesFile` FOREIGN KEY (`fileID`) REFERENCES `files` (`fileid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `tags` (
  `fileID` int(64) NOT NULL,
  `tag` varchar(256) NOT NULL,
  PRIMARY KEY (`fileID`,`tag`),
  CONSTRAINT `tagFile` FOREIGN KEY (`fileID`) REFERENCES `files` (`fileid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `comments` (
  `postid` int(128) NOT NULL,
  `time` datetime NOT NULL,
  `type` int(11) NOT NULL,
  `galleryID` int(64) DEFAULT NULL,
  `commentFrom` int(64) NOT NULL,
  `comment` varchar(2048) DEFAULT NULL,
  `rating` decimal(3,2) DEFAULT NULL,
  `replyOn` int(128) DEFAULT NULL,
  `fileID` int(64) DEFAULT NULL,
  `guestbookID` int(64) DEFAULT NULL,
  PRIMARY KEY (`postid`),
  UNIQUE KEY `postid_UNIQUE` (`postid`),
  KEY `commentsCommentOnGallery_idx` (`galleryID`),
  KEY `commentsCommentFrom_idx` (`commentFrom`),
  KEY `commentsFile_idx` (`fileID`),
  KEY `commentsGuestbook_idx` (`guestbookID`),
  KEY `commentsReply_idx` (`replyOn`),
  CONSTRAINT `commentsCommentFrom` FOREIGN KEY (`commentFrom`) REFERENCES `user` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `commentsFile` FOREIGN KEY (`fileID`) REFERENCES `files` (`fileid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `commentsGallery` FOREIGN KEY (`galleryID`) REFERENCES `galleries` (`galleryID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `commentsGuestbook` FOREIGN KEY (`guestbookID`) REFERENCES `user` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE `comments` 
ADD CONSTRAINT `commentsReply` FOREIGN KEY (`replyOn`) REFERENCES `comments` (`postid`) ON DELETE CASCADE ON UPDATE CASCADE;

