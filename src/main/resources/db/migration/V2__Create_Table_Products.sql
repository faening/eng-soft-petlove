CREATE TABLE IF NOT EXISTS `products` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    `description` tinytext NOT NULL,
    `bar_code` varchar(13) DEFAULT NULL,
    `brand_id` bigint(20) NOT NULL,
    `created_at` timestamp DEFAULT CURRENT_TIMESTAMP,
    `updated_at` timestamp DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`brand_id`) REFERENCES `brands` (`id`)
);