insert into user_registration
    (name,
    email,
    descricao,
    localizacao,
    site,
    nascimento,
    password,
    account_creation_date)
values
    ("Antony Gabriel",
    "antony@gmail.com",
    "Sou apaixonado por bikes e amo pedalar.",
    "Camaragibe - PE",
    "antony.com.br",
    '2000-06-08',
    "$10$5CHbUuEoM.KW8Kyx85DXhOjSNvO8cWmaAx.DQpKG8ln3GUvl/n0KK",
    CURDATE());