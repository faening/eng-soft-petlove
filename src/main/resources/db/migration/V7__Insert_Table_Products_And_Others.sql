INSERT INTO `products` (`name`, `description`, `bar_code`, `brand_id`, `created_at`, `updated_at`)
VALUES
    (
        "Ração Royal Canin Maxi para Cães Adultos de Porte Grande 15kg",
        "Ajuda no suporte a ossos e articulações que podem ser sobrecarregados pelo peso corporal; Ajudar a manter uma pele saudável;",
        "7896181200765",
        1,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP
    ),
    (
        "Ração Royal Canin Veterinary Satiety para Cães Adultos de Porte Pequeno com Excesso de Peso",
        "Indicada para cães adultos de pequeno porte;  Auxilia na perda de peso segura e reduz o risco de recuperação do peso; 97% dos cães perderam peso em 3 meses;",
        "7896181218364",
        1,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP
    ),
    (
        "Ração Hills Science Diet Pedaços Pequenos para Cães Adultos de Pequeno Porte Sabor Frango",
        "Proteínas de alta qualidade para uma condição corpórea ideal; Complexo com vitaminas C + E – antioxidantes comprovados;",
        "52742036236",
        3,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP
    ),
    (
        "Ração Whiskas para Gatos Adultos Sabor Mix de Carnes",
        "Ração premium 100% completa e balanceada; Desenvolvida nutricionalmente em conjunto com veterinários;",
        "7896029071489",
        14,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP
    ),
    (
        "Ração Nestlé Purina Pro Plan para Gatos Adultos Trato Urinário Sabor Frango",
        "Oferece nutrição específica que ajuda a manter o sistema urinário saudável; Promove a saúde e bem-estar geral dos gatos com predisposição a formação de cálculos urinários;",
        "7891000308363",
        2,
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP
    );

INSERT INTO `product_packages` (`name`, `price`, `product_id`, `created_at`, `updated_at`)
VALUES
	("15 kg", 426.61, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
	("1,5 kg", 130.04, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
	("7,5 kg", 478.71, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
	("800 g", 60.99, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
	("2,4 Kg", 159.99, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
	("6 Kg", 334.99, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
	("12 Kg", 479.99, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
	("2,7 Kg", 54.99, 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
	("10,1 Kg", 197.99, 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
	("400 g", 31.99, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
	("1 Kg", 47.99, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
	("3 Kg", 171.99, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
	("7,5 Kg", 328.99, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO `product_images` (`image_url`, `product_id`, `created_at`, `updated_at`)
VALUES
	("https://images.petz.com.br/fotos/1660162896325.jpg", 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ("https://images.petz.com.br/fotos/1660162899082.jpg", 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ("https://images.petz.com.br/fotos/1660162900048.jpg", 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ("https://images.petz.com.br/fotos/1666728054402.jpg", 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ("https://images.petz.com.br/fotos/1660153947268.jpg", 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ("https://images.petz.com.br/fotos/1692018152924.jpg", 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ("https://images.petz.com.br/fotos/1613058376821.jpg", 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ("https://images.petz.com.br/fotos/1695135261198.jpg", 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ("https://images.petz.com.br/fotos/1695135265711.jpg", 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ("https://images.petz.com.br/fotos/1627332520960.jpg", 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ("https://images.petz.com.br/fotos/1627332534017.jpg", 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ("https://images.petz.com.br/fotos/1627332553890.jpg", 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO `product_specifications` (`name`, `value`, `product_id`, `created_at`, `updated_at`)
VALUES
	("Idade", "Adulto", 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
	("Pet", "Cachorros", 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
	("Porte", "Grande", 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
	("Idade", "Adulto", 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
	("Pet", "Cachorro", 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
	("Porte", "Pequeno", 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
	("Idade", "Adulto", 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
	("Pet", "Cachorro", 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
	("Tipo", "Ração Seca", 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
	("Idade", "Adulto", 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
	("Pet", "Gatos", 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
	("Sabor", "Mix de Carnes", 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
	("Idade", "Adulto", 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
	("Pet", "Gatos", 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
	("Sabor", "Frango", 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);