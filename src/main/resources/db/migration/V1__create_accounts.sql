CREATE  TABLE  accounts(
    id uuid primary key,
    holder_name text not null,
    currency char(3) not null,
    available_balance numeric(19,2) not null,
    created_at timestamptz not null,
    CHECK ( available_balance >= 0 )
);