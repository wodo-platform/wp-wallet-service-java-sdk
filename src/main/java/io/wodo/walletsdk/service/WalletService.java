package io.wodo.walletsdk.service;

import io.wodo.walletsdk.domain.Wallet;
import io.wodo.walletsdk.enumtype.EnumStatus;
import io.wodo.walletsdk.exception.NotFoundException;
import io.wodo.walletsdk.model.request.WalletCreateRequest;
import io.wodo.walletsdk.model.request.WalletUpdateRequest;
import io.wodo.walletsdk.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;

    public Wallet createWallet(WalletCreateRequest createWalletRequest) {
        Wallet _wallet = new Wallet(createWalletRequest.getStatus(), createWalletRequest.getAmount());
        return walletRepository.save(_wallet);
    }

    public Page<Wallet> getAllWallets(Pageable pageable) {
        return walletRepository.findAll(pageable);
    }

    public Wallet findById(Long walletId) {
        Optional<Wallet> _wallet = walletRepository.findById(walletId);
        if (_wallet.isPresent() && _wallet.get().getStatus() == EnumStatus.ACTIVE) {
            return _wallet.get();
        } else {
            throw new NotFoundException();
        }
    }

    public Wallet updateWallet(Long walletId, WalletUpdateRequest walletUpdateRequest) {
        Wallet _wallet = findById(walletId);
        _wallet.setStatus(walletUpdateRequest.getStatus());
        _wallet.setAmount(walletUpdateRequest.getAmount());
        return walletRepository.save(_wallet);
    }

    public Wallet deleteWallet(Long walletId) {
        Wallet _wallet = findById(walletId);
        _wallet.setStatus(EnumStatus.DELETED);
        return walletRepository.save(_wallet);
    }
}