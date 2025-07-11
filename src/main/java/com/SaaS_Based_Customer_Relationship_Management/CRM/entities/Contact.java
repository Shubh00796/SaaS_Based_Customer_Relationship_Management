package com.SaaS_Based_Customer_Relationship_Management.CRM.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "contacts", indexes = {
        @Index(name = "idx_contact_email", columnList = "email"),
        @Index(name = "idx_contact_customer", columnList = "customer_id"),
        @Index(name = "idx_contact_tenant", columnList = "tenant_id")
})
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Column(name = "email", nullable = false)
    private String email;

    @NotNull(message = "CustomerId is required")
    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @NotNull(message = "TenantId is required")
    @Column(name = "tenant_id", nullable = false)
    private Long tenantId;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
