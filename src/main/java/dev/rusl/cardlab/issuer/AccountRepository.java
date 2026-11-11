package dev.rusl.cardlab.issuer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface AccountRepository extends JpaRepository<Account, UUID> {
}
