
CREATE TABLE  IF NOT EXISTS SOLAR_PAINEL (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    marca_solar_painel VARCHAR(255) NOT NULL,
    pv_module_efficiency DOUBLE PRECISION,
    pv_type VARCHAR(255) NOT NULL,
    open_circuit_voltage DOUBLE PRECISION,
    optimum_operating_voltage_Vmp DOUBLE PRECISION,
    short_circuit_current_isc DOUBLE PRECISION,
    optimum_operating_current_imp DOUBLE PRECISION,
    maximum_powerat_stc_pmax DOUBLE PRECISION,
    operating_temperature VARCHAR(30) NOT NULL,
    nominal_operating_cell_temperature VARCHAR(30) NOT NULL,
    temp_coefficientof_pmax DOUBLE PRECISION,
    temp_coefficientof_Voc DOUBLE PRECISION,
    temp_coefficientof_isc DOUBLE PRECISION
);

INSERT INTO SOLAR_PAINEL(
    marca_solar_painel,
    pv_module_efficiency,
    pv_type,
    open_circuit_voltage,
    optimum_operating_voltage_Vmp ,
    short_circuit_current_isc ,
    optimum_operating_current_imp ,
    maximum_powerat_stc_pmax ,
    operating_temperature ,
    nominal_operating_cell_temperature,
    temp_coefficientof_pmax ,
    temp_coefficientof_voc ,
    temp_coefficientof_isc
) VALUES
('RS6E-150P-RESUN',15.29,'Poly-crystalline',22.3,17.91,8.82,8.38,150.0,'-45~+85C','45',-0.39,-0.32,0.05),
('ZJNAC-280M-ZJNAC',20.7,'Mono-crystalline',37.86,31.86,9.32,8.79,280.0,'-45~+85C','44',-0.36,-0.30,0.046),
('ZJNAC-160M-ZJNAC',19.8,'Mono-crystalline',22.64,19.69,8.89,8.56,160.0,'-45~+85C','44',-0.36,-0.30,0.046),
('RS6E-155M-RESUN',18.05,'Mono-crystalline',24.46,20.64,8.31,7.51,155.0,'-40~+85C','45',-0.35,-0.28,0.048),
('ZJNAC-340M-ZJNAC',20.8,'Mono-crystalline',45.64,38.55,9.38,8.82,340.0,'-45~+85C','44',-0.36,-0.30,0.046),
('HiKu6 Mono PERC-CANADIANSOLAR',21.5,'Mono-crystalline',49.8,41.9,14.05,13.25,555.0,'-40~+85C','44',-0.34,-0.26,0.05),
('OSDA ODA450-36-MH-OSDA',20.26,'Mono-crystalline',50.22,41.40,11.48,10.87,450.0,'-45~+85C','45',-0.37,-0.286,0.057),
('Sunova SS-550-72-MDH-SUNOVA',21.28,'Mono-crystalline',49.60,40.83,14.04,13.48,550.0,'-45~+85C','45',-0.35,-0.27,0.048),
('ReneSola RS6-555M-E-RENESOLAR',21.48,'Mono-crystalline',49.95,42.10,14.04,13.19,555.0,'-40~+85C','45',-0.35,-0.27,0.048)
;