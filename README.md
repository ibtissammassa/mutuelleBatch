# Gestion des Dossiers de Mutuelle avec Spring Batch

This project implements a batch application using **Spring Batch** to automate the processing of mutual insurance claims. It includes features like data validation, reimbursement calculation, and archiving processed claims.

## Project Context

In a mutual insurance system, each claim (or "dossier") submitted by a policyholder contains consultations and medical treatments. This project aims to streamline the claim processing pipeline while ensuring accurate calculations for reimbursements based on predefined rules.

## Features

### 1. **Data Reading**
- Reads insurance claims from a JSON file using a `JsonItemReader`.
- Each claim includes:
  - Policyholder information: name, affiliation number, registration.
  - Beneficiary details: name, relationship, claim submission date.
  - Consultation and fees: total cost, consultation price, number of attachments.
  - Treatments: barcode, name, type, price, and availability.

### 2. **Data Validation**
- Validates essential fields, ensuring:
  - Non-empty policyholder name and affiliation number.
  - Positive values for consultation fees and total costs.
  - Presence of at least one treatment in the claim.

### 3. **Reimbursement Calculation**
- Applies fixed percentages for consultation reimbursements.
- Maps treatments to a reference database to:
  - Verify medication availability.
  - Calculate reimbursement based on reference price and percentage.

### 4. **Processing Workflow**
- Utilizes a `CompositeItemProcessor` to chain multiple processors:
  - `ValidationProcessor`: Validates claim data.
  - `CalculProcessor`: Calculates the total reimbursement amount.

#### Sub-Processors Include:
- **ConsultationProcessor**: Calculates consultation reimbursement.
- **TraitementMappingProcessor**: Maps treatments to reference data.
- **TraitementRemboursementProcessor**: Computes reimbursement for each treatment.
- **TotalRemboursementProcessor**: Aggregates consultation and treatment reimbursements.

### 5. **Data Archiving**
- Writes processed claims, including reimbursement amounts, to a database or an output file for archival purposes.

## Example Input

Sample JSON structure for claims:

```json
[
  {
    "nomAssure": "Ibrahimi",
    "numeroAffiliation": "AFF123456",
    "immatriculation": "IMM098765",
    "lienParente": "fils",
    "montantTotalFrais": 150.0,
    "prixConsultation": 50.0,
    "nombrePiecesJointes": 3,
    "nomBeneficiaire": "Omar",
    "dateDepotDossier": "2024-11-10",
    "traitements": [
      {
        "codeBarre": "1234567890",
        "existe": true,
        "nomMedicament": "Paracétamol",
        "typeMedicament": "Antalgique",
        "prixMedicament": 5.0
      },
      {
        "codeBarre": "0987654321",
        "existe": false,
        "nomMedicament": "Ibuprofène",
        "typeMedicament": "Anti-inflammatoire",
        "prixMedicament": 8.0
      }
    ]
  }
]
```

## Getting Started

### Prerequisites
- Java
- Spring Batch Framework
- Database (e.g., MySQL) for archiving data
- JSON files as input

### Running the Application
1. Clone the repository.
2. Configure the database connection in `application.properties`.
3. Provide the JSON input file in the specified directory.
4. Run the application using your preferred IDE or `mvn spring-boot:run`.

