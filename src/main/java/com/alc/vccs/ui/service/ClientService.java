package com.alc.vccs.ui.service;

import com.alc.vccs.ui.dto.ClientDto;
import com.alc.vccs.ui.model.Client;
import com.alc.vccs.ui.model.ClientCurrency;
import com.alc.vccs.ui.model.Clients;
import com.alc.vccs.ui.model.IdentityCard;
import com.alc.vccs.ui.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ClientService {
    private static final String SPLIT_DATE_REGEXP = "-";

    private final ClientRepository clientRepository;

    public List<Client> saveClients(List<ClientDto> clientDtos) {
        List<Client> toSaveClients = clientDtos
                .stream()
                .map(this::transformDtoToClient)
                .collect(Collectors.toList());

        return clientRepository.saveAll(toSaveClients);
    }

    public List<Long> deleteClients(List<Long> clientIds) {
        clientIds.forEach(clientRepository::deleteById);
        return clientIds;
    }

    public Client findClientById(Long clientId){
        return clientRepository.findById(clientId).orElseGet(Clients::getEmptyClient);
    }

    public List<Client> findAllById(List<Long> clientIds, int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Client> allClient = clientRepository.findAll(pageable);
        return allClient
                .filter(client -> clientIds.contains(client.getClientId()))
                .get()
                .collect(Collectors.toList());
    }

    private Client transformDtoToClient(ClientDto clientDto) {
        return Client
                .builder()
                .clientId(clientDto.getClientId())
                .name(clientDto.getName())
                .lastName(clientDto.getLastName())
                .fartherName(clientDto.getFartherName())
                .burnDate(stringDateToLocalDate(clientDto.getBurnDate()))
                .gender(clientDto.getGender())
                .identityCard(
                        IdentityCard
                                .builder()
                                .identityCardId(clientDto.getIdentityCardDto().getIdentityCardId())
                                .identityCardVersion(clientDto.getIdentityCardDto().getIdentityCardVersion())
                                .identityCardNumber(clientDto.getIdentityCardDto().getIdentityCardNumber())
                                .identityCardSupplier(clientDto.getIdentityCardDto().getIdentityCardSupplier())
                                .dateOfIdentityCardReceiving(stringDateToLocalDate(clientDto.getIdentityCardDto().getDateOfIdentityCardReceiving()))
                                .citiesByIdentityCard(clientDto.getIdentityCardDto().getCitiesByIdentityCard())
                                .addressByIdentityCard(clientDto.getIdentityCardDto().getAddressByIdentityCard())
                                .build()
                )
                .areaOfBurn(clientDto.getAreaOfBurn())
                .citiesByActualLiving(clientDto.getCitiesByActualLiving())
                .addressByActualLiving(clientDto.getAddressByActualLiving())
                .homePhone(clientDto.getHomePhone())
                .mobilePhone(clientDto.getMobilePhone())
                .familyStatus(clientDto.getFamilyStatus())
                .citizenship(clientDto.getCitizenship())
                .disability(clientDto.getDisability())
                .retiree(clientDto.getRetiree())
                .monthIncome(new ClientCurrency(clientDto.getMonthIncome()))
                .build();
    }

    private LocalDate stringDateToLocalDate(String stringDate) {
        List<String> dateParts = Arrays.asList(stringDate.split(SPLIT_DATE_REGEXP));
        int day = Integer.parseInt(dateParts.get(0));
        int month = Integer.parseInt(dateParts.get(1));
        int year = Integer.parseInt(dateParts.get(2));

        return LocalDate.of(year, month, day);
    }

}
