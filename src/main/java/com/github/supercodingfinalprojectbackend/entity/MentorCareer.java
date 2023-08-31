package com.github.supercodingfinalprojectbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Mentor_Careers")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MentorCareer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mentor_career_id", nullable = false)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mentor_id")
	private Mentor mentor;

	@Column(name = "company")
	private String company;

	@Column(name = "duty")
	private String duty;

	@Column(name = "period")
	private Integer period;
}