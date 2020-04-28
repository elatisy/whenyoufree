insert into user (
    nick, real_name, email,
    phone, created_at, updated_at
)
values (
    'admin', '管理员', 'elatisy@outlook.com',
    '13081850976', getdate(), getdate()
)