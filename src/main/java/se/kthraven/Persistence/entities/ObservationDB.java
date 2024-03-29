package se.kthraven.Persistence.entities;

import jakarta.persistence.*;

@Entity
@Cacheable
@Table(name = "observation")
public class ObservationDB {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private String id;
    private String observation;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private PersonDB patient;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(
            name = "encounter_observation",
            joinColumns = @JoinColumn(name = "observation_id"),
            inverseJoinColumns = @JoinColumn(name = "encounter_id")
    )
    private EncounterDB encounter;

    public ObservationDB(){

    }

    public ObservationDB(String id, String observation, PersonDB patient) {
        this.id = id;
        this.observation = observation;
        this.patient = patient;
    }

    public ObservationDB(String id, String observation, PersonDB patient, EncounterDB encounter) {
        this.id = id;
        this.observation = observation;
        this.patient = patient;
        this.encounter = encounter;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public PersonDB getPatient() {
        return patient;
    }

    public EncounterDB getEncounter() {
        return encounter;
    }

    public void setEncounter(EncounterDB encounter) {
        this.encounter = encounter;
    }
}
