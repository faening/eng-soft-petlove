CREATE TABLE `product_images` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `image_url` varchar(255) NOT NULL,
    `product_id` bigint(20) NOT NULL,
    `created_at` timestamp DEFAULT CURRENT_TIMESTAMP,
    `updated_at` timestamp DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
);