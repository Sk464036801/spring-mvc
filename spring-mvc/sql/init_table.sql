CREATE TABLE `user` (
    `id` varchar(36) NOT NULL,
    `name` varchar(45) DEFAULT NULL,
    `standard` varchar(45) DEFAULT NULL,
    `age` varchar(45) DEFAULT NULL,
    `sex` varchar(45) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8