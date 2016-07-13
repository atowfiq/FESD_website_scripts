insert into fedb.compound
select elementid,_chemical_formula_structural,_chemical_formula_sum,_space_group_IT_number,_symmetry_cell_setting,_symmetry_space_group_name_Hall,
_symmetry_space_group_name_HM, _cell_angle_alpha,case _cell_formula_units_Z when '?' then null else _cell_formula_units_Z  end
,_cell_length_a,_cell_length_b,_cell_length_c,_cell_volume,_cod_database_code
 from fedb.compound_backup;
 